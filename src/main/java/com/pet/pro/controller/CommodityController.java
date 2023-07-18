package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.service.ComGoodsService;
import com.pet.pro.service.impl.ComGoodsServiceImpl;
import com.pet.pro.entity.DTO.AddCommodityDTO;
import com.pet.pro.entity.StorageEntity;
import com.pet.pro.entity.views.ComGoodsView;
import com.pet.pro.mapper.CommodityMapper;
import com.pet.pro.service.impl.ComGoodsServiceImpl;
import com.pet.pro.service.impl.CommodityServiceImpl;
import com.pet.pro.service.impl.StorageServiceImpl;
import com.pet.pro.service.impl.StorageServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;


@RestController("CommodityController")
@RequestMapping("/commodity-entity")
public class CommodityController {


    private CommodityServiceImpl commodityServiceImpl;
    private ComGoodsServiceImpl comGoodsServiceImpl;
    private StorageServiceImpl storageServiceImpl;
    @Autowired
    public void setStorageServiceImpl(StorageServiceImpl storageServiceImpl) {
        this.storageServiceImpl = storageServiceImpl;
    }
    @Autowired
    public void setCommodityServiceImpl(CommodityServiceImpl commodityServiceImpl) {
        this.commodityServiceImpl = commodityServiceImpl;
    }
    @Autowired
    public void setComGoodsServiceImpl(ComGoodsServiceImpl comGoodsServiceImpl) {
        this.comGoodsServiceImpl = comGoodsServiceImpl;
    }

    @Autowired
    private ComGoodsService comGoodsService;

    @Autowired
    private CommodityMapper commodityMapper;


    @ApiOperation("商品分类")
    @GetMapping("/getCommodityType/{name}")
    public Result<?> getCommodityType(@PathVariable String name){
        QueryWrapper<ComGoodsView> wrapper = new QueryWrapper<>();
        wrapper.eq("type_name", name);
        wrapper.eq("state", "上架中");
        List<ComGoodsView> list = comGoodsService.list(wrapper);
        return Result.success(list);
    }

    @ApiOperation("所有商品")
    @GetMapping("/getCommodityInfo")
    public Result<?> getCommodityType(){
        QueryWrapper<ComGoodsView> wrapper = new QueryWrapper<>();
        wrapper.eq("state", "上架中");
        List<ComGoodsView> list = comGoodsService.list(wrapper);
        return Result.success(list);
    }


    /**
     * 添加商品
     * @param addCommodityDTO 增加的商品和库存实体信息
     * @return  Result<?>
     */
    @PostMapping("/addCommodity")
    public Result<?> addCommodity(@RequestBody AddCommodityDTO addCommodityDTO){

        UUID uuid = UUID.randomUUID();
        commodityServiceImpl.addCommodity(addCommodityDTO.getCommodity());
        StorageEntity storage = new StorageEntity();
        storage.setCommodityId(addCommodityDTO.getCommodity().getId());
        storage.setStorageId(uuid.toString());
        storage.setWarehouseId(addCommodityDTO.getWarehouseId());
        storage.setQuantity(addCommodityDTO.getQuantity());
        storageServiceImpl.addStorage(storage);
        return Result.success();
    }

    /**
     * 根据商店id查询商品信息
     * @param shopId 商店id
     * @return  Result<?>  Result.data=商品列表
     */

    @GetMapping("/selectCommodityByShopId/{shopId}")
    public Result<List<CommodityEntity>> selectCommodityByShopId(@PathVariable int shopId){
        return Result.success(commodityServiceImpl.selectCommodityByShopId(shopId));
    }

    /**
     * 根据商品id查询商品信息
     * @param commodityId 商品id
     * @return  Result<?>  Result.data=商品实体
     */


    /**
     * 根据商品id查询商品视图信息
     * @param shopId 商店id
     * @return Result<?>  Result.data=商品视图信息列表
     */

    @GetMapping("/selectComGoodsViewByShopId/{shopId}")
    public  Result<List<ComGoodsView>> selectComGoodsViewByShopId(@PathVariable int shopId){
        return Result.success(comGoodsServiceImpl.getComGoodsListByShopId(shopId));
    }

    /**
     * 根据商品id修改商品信息
     * @param commodityEntity 商品实体
     * @return  Result<?>  Result.data=
     */
    @PostMapping("/updateCommodityById")
    public  Result<?> updateCommodityById(@RequestBody CommodityEntity commodityEntity){
        int flag=commodityServiceImpl.updateCommodityById(commodityEntity);
        if(flag==1){
            return Result.success("修改成功");
        }else {
            return Result.fail("修改失败");
        }
    }

    /**
     * 根据商品id查询商品信息
     * @param commodityId 商品id
     * @return  Result<?>  Result.data=商品实体
     */
    @GetMapping("/selectCommodityById/{commodityId}")
    public Result<CommodityEntity> selectCommodityById(@PathVariable int commodityId){
        return Result.success(commodityServiceImpl.selectCommodityById(commodityId));
    }

    /**
     * 根据商店id查询商店所有商品具体信息
     *
     * @param shopId 商店id
     * @return Result<?> 商店所有商品具体信息
     */
    @ResponseBody
    @GetMapping("/getCommodityByShopId/{shopId}")
    public Result<?> getCommodityByShopId(@PathVariable("shopId") Integer shopId) {
        if (shopId != null) {
            return Result.success(this.comGoodsServiceImpl.getComGoodsListByShopId(shopId));
        } else {
            return Result.fail("查询条件不能为空");
        }
    }

    /**
     * 根据商店id进行商品种类查询
     *
     * @param shopId 商店id
     * @return 商品种类
     */
    @ResponseBody
    @PostMapping("/getCommodityTypeByShopId/{shopId}")
    public Result<?> getCommodityTypeByShopId(@PathVariable("shopId") Integer shopId) {
        if (shopId != null) {
            return Result.success(this.commodityServiceImpl.getCommodityTypeByShopId(shopId));
        } else {
            return Result.fail("查询条件不能为空");
        }
    }



    /** DoubleHong
     * 获取所有的商品视图
     * @return Result<?>  Result.data=商品视图信息列表
     */
    @GetMapping("/getAllComGoodsView")
    public Result<List<ComGoodsView>> getAllComGoodsView(){
        return Result.success(comGoodsServiceImpl.getAllGoods());
    }


//何栋梁
    @PostMapping("/getAllCommdities")
    public Result<?> getAllCommodities(){
        LambdaQueryWrapper<CommodityEntity> qurery = new LambdaQueryWrapper<>();
        qurery.like(CommodityEntity::getName,"");
        List<CommodityEntity> commodityEntities = commodityMapper.selectList(qurery);
        return Result.success(commodityEntities);
    }

    @GetMapping("/getById/{id}")
    public Result<?> getById(@PathVariable String id){
        LambdaQueryWrapper<CommodityEntity> query = new LambdaQueryWrapper<>();
        query.eq(CommodityEntity::getId, id);
        CommodityEntity commodityEntity = commodityMapper.selectOne(query);
        return Result.success(commodityEntity);
    }

    @PostMapping("/getCommdityByName/{name}")
    public Result<?> getCommodityByName(@PathVariable String name){
        LambdaQueryWrapper<CommodityEntity> query = new LambdaQueryWrapper<>();
        query.like(CommodityEntity::getName, name);
        List<CommodityEntity> commodityEntities = commodityMapper.selectList(query);
        return Result.success(commodityEntities);
    }
//何栋梁

}

