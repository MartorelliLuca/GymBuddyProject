package beans;

import exceptions.dataException.DataFieldException;

public class TrainerBean extends PersonBean{

    public TrainerBean(String username, PersonalInfoBean personalInfo, CredentialsBean credentialsBean/*, CardInfoBean cardInfoBean*/) {
        super(username, personalInfo, credentialsBean);
    }
}