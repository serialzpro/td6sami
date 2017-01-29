package fr.unice.iut.info.reseauSocial.core;

import fr.unice.iut.info.grapheSimple.GrapheSimple;
import fr.unice.iut.info.grapheX.Arc;
import fr.unice.iut.info.grapheX.Sommet;
import fr.unice.iut.info.reseauSocial.core.SocialNetwork;
import fr.unice.iut.info.grapheX.Graphe;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by axelm on 16/12/2016.
 */
public class MemberTest {
    private SocialNetwork socialNetworkTest;
    private Member memberTest;
    private Member memberTest2;
    private Member memberTest3;
    private Arc arcTest;

    @Before
    public void setUp() throws Exception {
        memberTest=new Member("Xavier",2,"con");
        memberTest2=new Member("Axel",30,"Boss");
        memberTest3= new Member("Antoine",40,"Adjudant");
        socialNetworkTest=  new SocialNetwork("test");
        socialNetworkTest.addMember("Axel",30,"Boss");
     //  socialNetworkTest.addMember("Xavier",2,"con");

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAge() throws Exception {

    }

    @Test
    public void getDescription() throws Exception {

    }

    @Test
    public void testAddMember()throws Exception{
        assertEquals(memberTest,socialNetworkTest.addMember("Xavier",2,"con"));
    }

    @Test
    public void testGetMembers() throws Exception{
        Collection<? extends MemberInterface> liste = socialNetworkTest.getMembers();
        assertEquals(true,liste.contains(memberTest2));
    }

    @Test
    public void testAjoutSommet() throws Exception {

        assertEquals(socialNetworkTest.getMember("Axel").ident(),memberTest2.ident());
    }

    @Test
    public void testRelateToRank() throws Exception{
        socialNetworkTest.relate(2,memberTest,memberTest2);
        Collection<? extends MemberInterface> membresAmis = socialNetworkTest.relateToRank(memberTest, 2);
        assertEquals(true,membresAmis.contains(memberTest2));


    }

    @Test
    public void testDistance() throws Exception{
        socialNetworkTest.addMember("Antoine",40,"Adjudant"); socialNetworkTest.addMember("Xavier",2,"con");
        socialNetworkTest.relate(2,memberTest,memberTest2); socialNetworkTest.relate(3,memberTest2,memberTest3);
        assertEquals(2,socialNetworkTest.distance(memberTest,memberTest2));
        System.out.println(socialNetworkTest.distance(memberTest,memberTest3));
    }





}