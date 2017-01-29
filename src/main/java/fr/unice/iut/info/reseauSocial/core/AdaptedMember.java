package fr.unice.iut.info.reseauSocial.core;

import fr.unice.iut.info.facebookGhost.User;
import fr.unice.iut.info.grapheX.Sommet;
import fr.unice.iut.info.facebookGhost.FacebookGhostNetwork;
/**
 * Created by axelm on 27/01/2017.
 *
 */
public class AdaptedMember extends Sommet implements MemberInterface {

    private User userAdapt;

    public AdaptedMember(User user) {
        super(user.getId());
        this.userAdapt= user;
    }

    @Override
    public int getAge() {
        return userAdapt.getAgeRange().getAge();
    }

    @Override
    public String getDescription() {
        return userAdapt.myProfil();
    }

    @Override
    public String ident() {
        return userAdapt.getId();
    }
}
