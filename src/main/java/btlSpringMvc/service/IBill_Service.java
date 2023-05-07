package btlSpringMvc.service;

import java.util.List;

import btlSpringMvc.entities.Receipts;

public interface IBill_Service {
	public Boolean insert(Receipts bill);
	public List<Receipts> findByUserId (Long userId);
	public List<Receipts> findAllBill();
}
