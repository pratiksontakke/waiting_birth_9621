package com.masai.service;

import com.masai.dao.CustomerDAO;
import com.masai.dao.SessionDAO;
import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.LoginDTO;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerDAO cDao;
	
	@Autowired
	private SessionDAO sDao;
	
	@Override
	public String logIntoAccount(LoginDTO dto)throws LoginException {
		Customer existingCustomer= cDao.findByMobileNo(dto.getMobileNumber());
		if(existingCustomer == null) {
			throw new LoginException("Please Enter a valid mobile number");
		}

		CurrentUserSession currentUserSession = sDao.findByUserId(existingCustomer.getCustomerId());

		if(currentUserSession!=null) {
			throw new LoginException("User already login with this userId");
		}

		if(existingCustomer.getMobileNumber().equals(dto.getMobileNumber()) && existingCustomer.getPassword().equals(dto.getPassword())) {
			String key= RandomString.make(6);
			CurrentUserSession newCurrentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(), key, LocalDateTime.now());
			sDao.save(newCurrentUserSession);
			return  newCurrentUserSession.toString();
		} else {
			throw new LoginException("Invalid mobile and Password");
		}

		/*Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findById(existingCustomer.getCustomerId());
		if(validCustomerSessionOpt.isPresent()) {
			throw new LoginException("User already Logged In with this number");
		}
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			String key= RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			sDao.save(currentUserSession);
			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
		*/
	}

	@Override
	public String logOutFromAccount(String key)throws LoginException {
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
		}
		sDao.delete(validCustomerSession);
		return "Logged Out !";
	}

}
