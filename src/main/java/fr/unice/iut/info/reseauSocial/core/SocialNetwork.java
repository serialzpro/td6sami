package fr.unice.iut.info.reseauSocial.core;

import fr.unice.iut.info.grapheSimple.GrapheSimple;
import fr.unice.iut.info.grapheSimple.ParcoursSimple;
import fr.unice.iut.info.grapheX.Arc;
import fr.unice.iut.info.grapheX.Identifiable;
import fr.unice.iut.info.grapheX.Sommet;

import java.util.*;

/**
 * Created by axelm on 16/12/2016.
 */
public class SocialNetwork extends GrapheSimple implements SocialNetworkInterface {

    private GrapheSimple graphe;
    private ParcoursSimple parcours;
    private String name;

    public SocialNetwork(String name){
        this.name=name;
        this.graphe = new GrapheSimple();
        parcours= new ParcoursSimple(this.graphe);
    }

    public MemberInterface getMember(String identifier) {
        return (MemberInterface) graphe.getSommet(identifier);
    }

    public Collection<? extends MemberInterface> getMembers() {
        Collection<? extends Sommet> liste = null;
        liste = graphe.sommets();
        return (Collection<? extends MemberInterface>) liste;

    }


    public MemberInterface addMember(String identifier, int age, String description) {
        Member membre = new Member(identifier,age,description);
        graphe.ajouterSommet(membre);
        return membre;
    }

    public void relate(int force, MemberInterface member, MemberInterface friend) {
        if (graphe.existeArc((Member)member,(Member) friend))
        {
            graphe.enleverArc((Member)member,(Member) friend);
        }
        graphe.ajouterArc((Member)member,(Member)friend,force);

        if (graphe.existeArc((Member)friend,(Member) member)){
            graphe.enleverArc((Member)friend,(Member) member);
        }
        graphe.ajouterArc((Member)friend,(Member)member,force);
    }


    public Collection<? extends MemberInterface> relateToRank(MemberInterface member, int rank) {
        Collection<? extends Sommet> listeRelate = null;
       listeRelate=  parcours.voisinsAuRang((Sommet) member,rank);

        return (Collection<? extends MemberInterface>) listeRelate;
    }

    public int distance(MemberInterface member1, MemberInterface member2) {
        return parcours.cheminLePlusCourt((Sommet) member1,(Sommet)member2).distance();

    }

    public void addOtherNetwork(Observable o) {


    }

    public void update(Observable o, Object arg) {

    }


    @Override
    public String toString() {
        return "SocialNetwork{" +
                "graphe=" + graphe +
                '}';
    }

    public GrapheSimple getGraphe() {
        return graphe;
    }

}
