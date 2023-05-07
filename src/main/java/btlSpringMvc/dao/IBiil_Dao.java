package btlSpringMvc.dao;

import java.util.List;

import btlSpringMvc.entities.Receipts;

public interface IBiil_Dao {
	public Boolean insert(Receipts bill);
	public List<Receipts> findByUserId (Long id);
	public List<Receipts> findAllBill();
}
