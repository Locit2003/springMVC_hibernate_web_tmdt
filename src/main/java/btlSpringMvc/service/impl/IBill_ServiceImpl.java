package btlSpringMvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btlSpringMvc.dao.IBiil_Dao;
import btlSpringMvc.entities.Receipts;
import btlSpringMvc.service.IBill_Service;

@Service
public class IBill_ServiceImpl implements IBill_Service{
	
	@Autowired
	private IBiil_Dao bill_Dao;

	@Override
	public Boolean insert(Receipts bill) {
		return bill_Dao.insert(bill);
	}

	@Override
	public List<Receipts> findByUserId(Long userId) {
		return bill_Dao.findByUserId(userId);
	}

	@Override
	public List<Receipts> findAllBill() {
		return bill_Dao.findAllBill();
	}

}
