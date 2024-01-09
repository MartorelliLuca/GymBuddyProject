package controllers;

import beans.CuponsBean;
import beans.GymInfoBean;
import beans.MembershipBean;
import beans.SearchGymBean;
import database.dao.CouponsDAO;
import database.dao.GymDAO;
import database.dao.MembershipDAO;
import model.Gym;
import model.Membership;
import model.cupons.Cupon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class ManageMembershipController {
    protected GymDAO gymDao;

    public ManageMembershipController() {
        gymDao = new GymDAO();
    }

    public List<MembershipBean> getMembershipList(GymInfoBean onlyGymNameBean) {
        MembershipDAO membershipDAO=new MembershipDAO();
        List<Membership> listOfMemberships = membershipDAO.getMembership(onlyGymNameBean.getName());
        List<MembershipBean> beanList = new ArrayList<>();
        for (Membership membership : listOfMemberships) {
            beanList.add(new MembershipBean(
                    membership.getCode(),
                    onlyGymNameBean.getName(),
                    membership.getName(),
                    membership.getDescription(),
                    membership.getPrice(),
                    membership.getDuration(),
                    membership.getPoints()));
        }
        return beanList;
    }

    public List<CuponsBean> getCouponsList(GymInfoBean onlyNameGym){
        CouponsDAO couponsDAO=new CouponsDAO();
        List<Cupon> listOfCoupons;
        listOfCoupons=couponsDAO.getCoupons(onlyNameGym.getName());
        List <CuponsBean> listOfCouponsBeans=new ArrayList<>();
        for(Cupon cupon: listOfCoupons ){
            listOfCouponsBeans.add(new CuponsBean(cupon.getCode(),
                    cupon.getPointsPrice(),
                    cupon.getName(),
                    cupon.getDescription(),
                    cupon.getOnlyForNewUsers(),
                    cupon.isCumulative(),
                    cupon.getType(),
                    cupon.getCouponsValue()));
        }
        return listOfCouponsBeans;
    }

    private boolean stringExistsInText(String toBeSearched, String text) {
        return Pattern.compile(Pattern.quote(toBeSearched), Pattern.CASE_INSENSITIVE).matcher(text).find();
    }

    public List<GymInfoBean> searchGym(SearchGymBean searchBean) {
        List<Gym> gyms = gymDao.loadAllGyms();
        List<GymInfoBean> beanList = new ArrayList<>();
        for (Gym gym : gyms) {
            boolean isNameValid = (searchBean.getName() == null) || stringExistsInText(searchBean.getName(), gym.getGymName());
            boolean isAddressValid = (searchBean.getAddress() == null) || stringExistsInText(searchBean.getAddress(), gym.getAddress());
            boolean isCityValid = (searchBean.getCity() == null) || stringExistsInText(searchBean.getCity(), gym.getCity());
            boolean isCountryValid = (searchBean.getCountry() == null) || stringExistsInText(searchBean.getCountry(), gym.getCountry());

            if (isNameValid && isAddressValid && isCityValid && isCountryValid) {
                beanList.add(new GymInfoBean(gym.getGymName(),
                        gym.getAddress(),
                        gym.getCity(),
                        gym.getIban(),
                        gym.getCountry()));
            }
        }
        return beanList;
    }
}