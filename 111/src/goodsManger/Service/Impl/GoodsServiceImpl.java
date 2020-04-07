package goodsManger.Service.Impl;

import goodsManger.Dao.goodsDao;
import goodsManger.Service.GoodsService;
import goodsManger.model.Goods;
import googsManger.Dao.Impl.goodsDaoImpl;

public class GoodsServiceImpl implements GoodsService{
goodsDao gd=new goodsDaoImpl();
Goods goods=new Goods();
	@Override
	public void addGoods() {
		// TODO Auto-generated method stub
		gd.addGoods(goods);
	}

}
