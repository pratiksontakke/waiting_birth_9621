package com.masai.service;

import com.masai.dao.BeneficiaryDetailsDAO;
import com.masai.dao.CustomerDAO;
import com.masai.dao.SessionDAO;
import com.masai.dao.WalletDAO;
import com.masai.exception.BeneficiaryDetailsException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.BeneficiaryDetails;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BeneficiaryDetailsServiceImpl implements BeneficiaryDetailsService {

    @Autowired
    private BeneficiaryDetailsDAO BeneficiaryDao;
    @Autowired
    SessionDAO sessionDAO;

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    WalletDAO walletDAO;

    public CurrentUserSession isLogin(String key) throws LoginException {
        CurrentUserSession currentUserSession = sessionDAO.findByUuid(key);
        if (currentUserSession != null)
            return currentUserSession;
        else
            return null;
    }

    @Override
    public BeneficiaryDetails addBeneficiaryDetails(String key, BeneficiaryDetails Bd) throws CustomerException, LoginException {

        CurrentUserSession aao = isLogin(key);
        if (aao != null) {
            Customer customer = customerDAO.findByMobileNumber(aao.getUserId());
            Wallet wallet = customer.getWallet();
            wallet.getBeneficiaryDetails().add(Bd);
            Bd.setWallet(wallet);
            walletDAO.save(wallet);
            System.out.println("Bhagwan Hai Kaha re tu");
            return Bd;
        } else {
            throw new LoginException("You are not login");
        }


    }


    @Override
    public BeneficiaryDetails deleteBeneficiaryDetails(String key, Integer Bid) throws CustomerException, LoginException, BeneficiaryDetailsException {

        CurrentUserSession aao = isLogin(key);

        if (aao != null) {
            System.out.println("Hi baby");

            Optional<BeneficiaryDetails> beneficiaryDetails = BeneficiaryDao.findById(Bid);

            System.out.println("Yea baby");

            if (beneficiaryDetails.isPresent()) {
                System.out.println(beneficiaryDetails.get() + " ----------------------------");
//                BeneficiaryDao.(beneficiaryDetails.get());

                BeneficiaryDao.delete(beneficiaryDetails.get());

                System.out.println(beneficiaryDetails.get() + " ----------------------------");

                return beneficiaryDetails.get();

            } else {
                throw new BeneficiaryDetailsException("no Beneficiary found  with this Id ! ");
            }
        } else {
            throw new LoginException("you are not logined !");
        }


    }

    @Override
    public BeneficiaryDetails getBeneficiaryDetailsById(String key, Integer Bid) throws CustomerException, LoginException, BeneficiaryDetailsException {


        CurrentUserSession aao = isLogin(key);

        if (aao != null) {
            Customer customer = customerDAO.findByMobileNumber(aao.getUserId());

            Optional<BeneficiaryDetails> beneficiaryDetails = BeneficiaryDao.findById(Bid);
            System.out.println(" before present  ----------------------------");
            if (beneficiaryDetails.isPresent()) {

                System.out.println(beneficiaryDetails.get() + " ----------------------------");
                return beneficiaryDetails.get();

            } else {
                throw new BeneficiaryDetailsException("no Beneficiary found  with this Id ! ");
            }
        } else {
            throw new LoginException("you are not logined !");
        }


    }

    @Override
    public Set<BeneficiaryDetails> getAllBeneficiaryDetails(String key) throws CustomerException, LoginException, BeneficiaryDetailsException {

        CurrentUserSession aao = isLogin(key);

        if (aao != null) {
            Customer customer = customerDAO.findByMobileNumber(aao.getUserId());

            Set<BeneficiaryDetails> beneficiaryDetails = customer.getWallet().getBeneficiaryDetails();
            if (beneficiaryDetails.size() > 0) {
                return beneficiaryDetails;
            } else {
                throw new BeneficiaryDetailsException("no Beneficiary found  with this Id ! ");
            }
        } else {
            throw new LoginException("you are not logined !");
        }


    }
//    1.add beneficiary -> returns benefDetails by taking bd
//2. delete beneficiary -> returns benefDetails by taking bd
//3. view benefDetails(single ) -> returns bd by taking mobile
//4. viewListofBd(list) -> by taking customer object;

}
