package com.pet.pro.controller;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.DTO.RegisterDTO;
import com.pet.pro.entity.LoginEntity;
import com.pet.pro.entity.MerchantUserEntity;
import com.pet.pro.entity.RegularUserEntity;
import com.pet.pro.entity.views.MerchantUserView;
import com.pet.pro.service.LoginService;
import com.pet.pro.service.RegularUserService;
import com.pet.pro.service.impl.MerchantUserServiceImpl;
import com.pet.pro.service.impl.RegularUserServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("LoginController")
@RequestMapping("/login-entity")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegularUserServiceImpl regularUserService;

    @Autowired
    private MerchantUserServiceImpl merchantUserService;
    /**
     * 用户名密码登录
     * @param username 用户名
     * @param password 密码
     * @return token、null、error
     */
    @PostMapping("/Login/{username}/{password}")
    public Result<?> Login(@PathVariable String username,@PathVariable String password){
        QueryWrapper<LoginEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);

        if(loginService.list(wrapper).isEmpty()){//未查到该账号
            return Result.success("null","未查到账号");
        }else{//查到账号
            if(loginService.getOne(wrapper).getPassword().equals(password)){//密码正确
                String permission = loginService.getOne(wrapper).getGrade();//权限
                String phone = loginService.getOne(wrapper).getPhone();//手机号
                String secret = "cg";
                String token = JWT.create().withClaim("username",username).withClaim("phone",phone).
                        withClaim("permission",permission).sign(Algorithm.HMAC256(secret));
                return Result.success(token,permission);
            }else{//密码错误
                System.out.println(4);
                return Result.success("error","密码错误");
            }
        }
    }
    /**
     * 手机验证码登录
     * @param phone 手机号
     * @return token、null
     */
    @PostMapping("/LoginByPhone/{phone}")
    public Result<?> LoginByPhone(@PathVariable String phone){
        QueryWrapper<LoginEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("phone",phone);
        if(loginService.list(wrapper).isEmpty()){//未查到该手机号
            return Result.success("null","未查到手机号");
        }else{
            String permission = loginService.getOne(wrapper).getGrade();//权限
            String username = loginService.getOne(wrapper).getUsername();//用户名
            String secret = "cg";
            String token = JWT.create().withClaim("username",username).withClaim("phone",phone).
                    withClaim("permission",permission).sign(Algorithm.HMAC256(secret));
            return Result.success(token,permission);
        }
    }

    /**
     * 查询账号是否存在
     * @param username 账号
     * @return phone
     */
    @PostMapping("/SelectUserName/{username}")
    public Result<?> SelectUserName(@PathVariable String username){
        QueryWrapper<LoginEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        if(loginService.list(wrapper).isEmpty()){
            return Result.success("error","未查询到用户");
        }else{
            String phone = loginService.getOne(wrapper).getPhone();
            return Result.success(phone,"查询成功");
        }
    }

    /**
     * 查询账号
     * @param phone 电话
     * @return token、null、error
     */
    @PostMapping("/SelectPhone/{phone}")
    public Result<?> SelectPhone(@PathVariable String phone){
        QueryWrapper<LoginEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("phone",phone);
        if(loginService.list(wrapper).isEmpty()){
            return Result.success("error","查询不到电话");
        }else{
            String key = RandomStringUtils.randomNumeric(6);//生成6位数的验证码
            return Result.success(key,"验证码");
        }
    }

    /**
     * 注册时候查询电话号码是否存在
     * @param phone 电话
     * @return
     */
    @PostMapping("/RegisterSelectPhone/{phone}")
    public Result<?> RegisterSelectPhone(@PathVariable String phone){
        QueryWrapper<LoginEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("phone",phone);
        if(loginService.list(wrapper).isEmpty()){
            String key = RandomStringUtils.randomNumeric(6);//生成6位数的验证码
            return Result.success(key,"验证码");
        }else{
            return Result.success("error","电话已存在");
        }
    }

    /**
     * 修改密码
     * @param phone 电话
     * @param password 密码
     */
    @PostMapping("/UpdatePassword/{phone}/{password}")
    public Result<?> UpdatePassword(@PathVariable String phone,@PathVariable String password){
        QueryWrapper<LoginEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("phone",phone);
        LoginEntity loginEntity = loginService.getOne(wrapper);
        loginEntity.setPassword(password);
        loginService.updateById(loginEntity);
        return Result.success();
    }

    /**
     * 更换头像
     * @param merchantUserView 用户名、头像
     */
    @PostMapping("/UpdateAvatar")
    public Result<?> UpdateAvatar(@RequestBody MerchantUserView merchantUserView){
        String username = merchantUserView.getUsername();
        String avatar = merchantUserView.getAvatar();
        QueryWrapper<LoginEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        LoginEntity loginEntity = loginService.getOne(wrapper);
        loginEntity.setAvatar(avatar);
        loginService.updateById(loginEntity);
        return Result.success();
    }

    /**
     * 更换手机号
     * @param phone 手机号
     * @param username 用户名
     */
    @PostMapping("/UpdatePhone/{username}/{phone}")
    public Result<?> UpdatePhone(@PathVariable String username,@PathVariable String phone){
        QueryWrapper<LoginEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        LoginEntity loginEntity = loginService.getOne(wrapper);
        loginEntity.setPhone(phone);
        loginService.updateById(loginEntity);
        return Result.success();
    }

    @PostMapping("/Register")
    public Result<?> Register(@RequestBody RegisterDTO registerDTO){
        long randomNumber = ThreadLocalRandom.current().nextLong(100000000, 1000000000);
        registerDTO.getLoginEntity().setUsername(String.valueOf(randomNumber));
        loginService.save(registerDTO.getLoginEntity());
        if (registerDTO.getLoginEntity().getGrade().equals("1") ) {
            RegularUserEntity regularUserEntity = new RegularUserEntity();
            regularUserEntity.setLoginId(registerDTO.getLoginEntity().getLoginId());
            regularUserEntity.setRegularName(registerDTO.getRegularName());
            regularUserEntity.setBirthday(registerDTO.getBirthday());
            regularUserEntity.setNickname(registerDTO.getNickname());
            if (regularUserService.save(regularUserEntity)) {
                return Result.success(randomNumber);
            }
        }else {
            MerchantUserEntity merchantUserEntity = new MerchantUserEntity();
            merchantUserEntity.setLoginId(registerDTO.getLoginEntity().getLoginId());
            merchantUserEntity.setMerchantName(registerDTO.getMerchantName());
            merchantUserEntity.setMerchantAddress(registerDTO.getMerchantAddress());
            if (merchantUserService.save(merchantUserEntity)) {
                return Result.success(randomNumber);
            }
        }
       return Result.success("error","注册失败");
    }
}

