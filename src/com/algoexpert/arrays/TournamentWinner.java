package com.algoexpert.arrays;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/*
  There's an algorithms tournament taking place in which teams of programmers
  compete against each other to solve algorithmic problems as fast as possible.
  Teams compete in a round robin, where each team faces off against all other
  teams. Only two teams compete against each other at a time, and for each
  competition, one team is designated the home team, while the other team is the
  away team. In each competition there's always one winner and one loser; there
  are no ties. A team receives 3 points if it wins and 0 points if it loses. The
  winner of the tournament is the team that receives the most amount of points.


  Given an array of pairs representing the teams that have competed against each
  other and an array containing the results of each competition, write a
  function that returns the winner of the tournament. The input arrays are named
  <span>competitions</span> and <span>results</span>, respectively. The
  <span>competitions</span> array has elements in the form of
  <span>[homeTeam, awayTeam]</span>, where each team is a string of at most 30
  characters representing the name of the team. The results array
  contains information about the winner of each corresponding competition in the
  <span>competitions</span>  array. Specifically, <span>results[i]</span>  denotes
  the winner of <span>competitions[i]</span>, where a <span>1</span> in the
  <span>results</span> array means that the home team in the corresponding
  competition won and a <span>0</span> means that the away team won.

  It's guaranteed that exactly one team will win the tournament and that each
  team will compete against all other teams exactly once. It's also guaranteed
  that the tournament will always have at least two teams.

<span class="CodeEditor-promptParameter">competitions</span> = [
  ["HTML", "C#"],
  ["C#", "Python"],
  ["Python", "HTML"],
]
<span class="CodeEditor-promptParameter">results</span> = [0, 0, 1]
<h3>Sample Output</h3>"Python"

  */
public class TournamentWinner {
    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        Map<String,Integer> pointsMap =  new HashMap<>();

        //System.out.println("competitions  :: "+competitions);

        int counter =0;
        for(ArrayList<String> competition:competitions){
            //System.out.println(pointsMap.get(counter));
            if(results.get(counter)==0){
                pointsMap.put(competition.get(0),pointsMap.getOrDefault(competition.get(0),0)+0);
                pointsMap.put(competition.get(1),pointsMap.getOrDefault(competition.get(1),0)+3);
            }
            else{
                pointsMap.put(competition.get(0),pointsMap.getOrDefault(competition.get(0),0)+3);
                pointsMap.put(competition.get(1),pointsMap.getOrDefault(competition.get(1),0)+1);
            }
            //System.out.println(pointsMap);
            counter++;
        }



        for(Map.Entry<String, Integer> entry: pointsMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        System.out.println("\n"+
        pointsMap.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).
                findFirst().get().getKey());
        ;

        return null;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> a =  new ArrayList<>(Arrays.asList("HTML","C#"));
        list.add(new ArrayList<>(Arrays.asList("HTML","C#")));
        list.add(new ArrayList<>(Arrays.asList("C#","Python")));
        list.add(new ArrayList<>(Arrays.asList("Python","HTML")));

        tournamentWinner(list,new ArrayList<Integer>(Arrays.asList(0,0,1)));
    }
}
