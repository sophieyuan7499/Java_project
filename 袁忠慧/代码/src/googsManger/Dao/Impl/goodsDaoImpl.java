package googsManger.Dao.Impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import goodsManger.Dao.goodsDao;
import goodsManger.model.Goods;

public class goodsDaoImpl implements goodsDao{
	QueryRunner runner= new QueryRunner(goodsManger.util.JdbcUtil2.getDataSource());
	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		String sql="insert into goods values(?,?,?,?,?)";
		Object[] param= {null,goods.getName(),goods.getType(),goods.getPrice(),goods.getDay()};
		try {
			runner.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
