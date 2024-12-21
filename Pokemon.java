
// import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
// import org.junit.jupiter.api.Test;

public class Pokemon {
  static Scanner obj = new Scanner(System.in);
  static String activePokemon = null;
  static List<String> alivePokemon = new ArrayList<String>();
  static List<String> faintedPokemon = new ArrayList<String>();
  
  static Integer[] squirtleStats = { 56, 61, 83, 64, 55, 15 };
  static Integer[] squirtleCurStats = { 56, 61, 83, 64, 55, 15 };
  static List<String> squirtleStatus = new ArrayList<String>();
  static String[] squirtleTypes = { "Water", "None" };
  static String[] squirtleMoves = { "Tackle", "Tail Whip", "Bubble", "Watergun" };
  
  static Integer[] charmanderStats = { 50, 67, 55, 64, 83, 15 };
  static Integer[] charmanderCurStats = { 50, 67, 55, 64, 83, 15 };
  static List<String> charmanderStatus = new ArrayList<String>();
  static String[] charmanderTypes = { "Fire", "None" };
  static String[] charmanderMoves = { "Scratch", "Growl", "Ember", "Leer" };
  
  static Integer[] bulbasaurStats = { 58, 63, 63, 83, 58, 15 };
  static Integer[] bulbasaurCurStats = { 58, 63, 63, 83, 58, 15 };
  static List<String> bulbasaurStatus = new ArrayList<String>();
  static String[] bulbasaurTypes = { "Grass", "Poison" };
  static String[] bulbasaurMoves = { "Tackle", "Growl", "Leech Seed", "Vine Whip" };
  
  static Integer[] tackle = { 35, 95, 35 };
  static String[] tackleStats = { "Normal", "Physical", "None" };
  
  static Integer[] tailWhip = { 0, 100, 30 };
  static String[] tailWhipStats = { "Normal", "Status", "DefDown" };
  
  static Integer[] bubble = { 20, 100, 30 };
  static String[] bubbleStats = { "Water", "Special", "None" };
  
  static Integer[] watergun = { 40, 100, 30 };
  static String[] watergunStats = { "Water", "Special", "None" };
  
  
  static Integer[] scratch = { 40, 100, 35 };
  static String[] scratchStats = { "Normal", "Physical", "None" };

  static Integer[] growl = { 0, 100, 40 };
  static String[] growlStats = { "Normal", "Effect", "AtkDown" };

  static Integer[] ember = { 40, 100, 25 };
  static String[] emberStats = { "Fire", "Special", "Burn" };
  //Halves Attack and inflicts 1/16 damage
  
  static Integer[] leer = { 40, 100, 30 };
  static String[] leerStats = { "Normal", "Effect", "DefDown" };

  static Integer[] leechSeed = { 0, 90, 10 };
  static String[] leechSeedStats = { "Grass", "Effect", "Seeding" };
  //1/16 of the seeded Pokémon's HP is drained. 

  static Integer[] vineWhip = { 35, 100, 10 };
  static String[] vineWhipStats = { "Grass", "Effect", "None" };


  //Brock's Pokemon

  static String activeOppPokemon = null;
  static String[] aliveOppPokemon = { "Geodude", "Onix" };
  
  //Geodude lvl 12
  static Integer[] geodudeStats = { 49, 98, 122, 37, 24, 12 };
  static Integer[] geodudeCurStats = { 49, 98, 122, 37, 24, 12 };
  static List<String> geodudeStatus = new ArrayList<String>();
  static String[] geodudeTypes = { "Rock", "Ground" };
  static String[] geodudeMoves = { "Tackle", "Defense Curl" };

  //Onix lvl 14
  static Integer[] onixStats = { 44, 57, 202, 38, 88, 14 };
  static Integer[] onixCurStats = { 44, 57, 202, 38, 88, 14 };
  static List<String> onixStatus = new ArrayList<String>();
  static String[] onixTypes = { "Rock", "Ground" };
  static String[] onixMoves = { "Tackle", "Screech", "Bide" };

  static Integer[] defenseCurl = { 0, 100, 40 };
  static String[] defenseCurlStats = { "Normal", "Effect", "DefUp" };

  static Integer[] screech = { 0, 85, 40 };
  static String[] screechStats = { "Normal", "Effect", "DefDownDown" };

  static Integer[] bide = { 0, 100, 10 };
  static String[] bideStats = { "Normal", "Physical", "None" };

  static int burnTimer = 0;

  static int bideTimer = 0;
  static int bideStartHealth = 0;
  static int bideEndHealth = 0;

  static boolean justFainted = true;

  static boolean unchosen = true;

  public static void main(String[] args) {
    alivePokemon.add("Squirtle");
    alivePokemon.add("Bulbasaur");
    alivePokemon.add("Charmander");


    System.out.println("You are challenged by Brock the Rock Type gym leader!");
    Wait(1000);
    System.out.println("Brock sends out his Geodude!");
    activeOppPokemon = "Geodude";
    Wait(1000);
    System.out.println("Choose your Pokemon!");
    Wait(1000);
    System.out.println("1. Squirtle");
    Wait(500);
    System.out.println("2. Charmander");
    Wait(500);
    System.out.println("3. Bulbasaur");
    Wait(500);
    while (unchosen) {
      String choice = obj.nextLine();
      if (choice.equals("1")) {
        System.out.println("Squirtle I choose you!");
        Wait(1000);
        System.out.println("Trainer Red sent out Squirtle");
        Wait(1000);
        activePokemon = "Squirtle";
        unchosen = false;
      }
      if (choice.equals("2")) {
        System.out.println("Charmander I choose you!");
        Wait(1000);
        System.out.println("Trainer Red sent out Charmander");
        Wait(1000);
        activePokemon = "Charmander";
        unchosen = false;
      }
      if (choice.equals("3")) {
        System.out.println("Bulbasaur I choose you!");
        Wait(1000);
        System.out.println("Trainer Red sent out Bulbasaur");
        Wait(1000);
        activePokemon = "Bulbasaur";
        unchosen = false;

      }

    }
    boolean fighting = true;
    while (fighting) {
      Fight();
      CheckBrock();
      if(GetActivePokemonStats(activePokemon)[0] <= 0)
      {
        System.out.println("Red's " + activePokemon + " fainted!");
        Wait(1000);
        Switch();
      }
      Status(activeOppPokemon, activePokemon);
      CheckBrock();
      if(GetActivePokemonStats(activePokemon)[0] <= 0)
      {
        System.out.println("Red's " + activePokemon + " fainted!");
        Wait(1000);
        Switch();
      }
      OppFight();
      CheckBrock();
      if(GetActivePokemonStats(activePokemon)[0] <= 0)
      {
        System.out.println("Red's " + activePokemon + " fainted!");
        Wait(1000);
        Switch();
      }
      Status(activePokemon, activeOppPokemon);
      CheckBrock();
      if(GetActivePokemonStats(activePokemon)[0] <= 0)
      {
        System.out.println("Red's " + activePokemon + " fainted!");
        Wait(1000);
        Switch();
      }
    }
  }

  public static void Fight() {
    unchosen = true;
    while (unchosen) {
      System.out.println("What will you do?");
      Wait(500);
      System.out.println("1. Fight");
      Wait(500);
      System.out.println("2. Bag");
      Wait(500);
      System.out.println("3. Pokemon");
      Wait(500);
      System.out.println("4. Run");
      Wait(500);
      String choice = obj.nextLine();
      if (choice.equals("1")) {
        System.out.println("What will " + activePokemon + " do?");
        if (activePokemon.equals("Squirtle")) {
          while (unchosen) {
            System.out.println("1. Tackle  " + tackle[2] + " pp");
            Wait(500);
            System.out.println("2. Tail Whip  " + tailWhip[2] + " pp");
            Wait(500);
            System.out.println("3. Bubble " + bubble[2] + " pp");
            Wait(500);
            System.out.println("4. Watergun " + watergun[2] + " pp");
            Wait(500);
            System.out.println("5. Back");
            Wait(1000);
            String move = obj.nextLine();
            if (move.equals("1")) {
              System.out.println("Squirtle used Tackle!");
              Wait(1000);
              Random rand = new Random();
              int min = 0, max = 100;
              int random = rand.nextInt(max - min + 1) + min;
              if (random <= tackle[1]) {
                if (random < 10) {
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( squirtleCurStats[5], 2, tackle[0], squirtleCurStats[1], GetActivePokemonStats(activeOppPokemon)[2], 1f, 0.5f, 1f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  System.out.println("It's a critical  hit!");
                  Wait(1000);
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining.");
                  Wait(1000);

                } else {
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( squirtleCurStats[5], 1, tackle[0], squirtleCurStats[1], GetActivePokemonStats(activeOppPokemon)[2], 1f, 0.5f, 1f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  System.out.println("It's a hit!");
                  Wait(1000);
                  System.out.println("It's not very effective!");
                  Wait(1000);
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining.");
                  Wait(1000);
                }
              } else {
                System.out.println("But it failed");
                Wait(1000);
              }
              unchosen = false;
            }
            if (move.equals("2")) {
              System.out.println("Squirtle used Tail Whip!");
              Wait(1000);
              System.out.println(activeOppPokemon + "'s defense fell!");
              Wait(1000);
              GetActivePokemonStats(activeOppPokemon)[2] -= 2;
              unchosen = false;

            }
            if (move.equals("3")) {
              System.out.println("Squirtle used Bubble!");
              Random rand = new Random();
              int min = 0, max = 100;
              int random = rand.nextInt(max - min + 1) + min;
              if (random <= bubble[1]) {
                if (random < 10) {
                  System.out.println("It's a critical  hit!");
                  Wait(1000);
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( squirtleCurStats[5], 2, bubble[0], squirtleCurStats[3], GetActivePokemonStats(activeOppPokemon)[3], 1.5f, 2f, 2f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining.");
                  Wait(1000);

                } else {
                  System.out.println("It's a hit!");
                  Wait(1000);
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( squirtleCurStats[5], 1, bubble[0], squirtleCurStats[3], GetActivePokemonStats(activeOppPokemon)[3], 1.5f, 2f, 2f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  System.out.println("It's super effective!");
                  Wait(1000);
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining.");
                  Wait(1000);
                }
              } else {
                System.out.println("But it failed");
                Wait(1000);
              }
              unchosen = false;
            }
            if (move.equals("4")) {
              System.out.println("Squirtle used Watergun!");
              Wait(1000);
              Random rand = new Random();
              int min = 0, max = 100;
              int random = rand.nextInt(max - min + 1) + min;
              if (random <= watergun[1]) {
                if (random < 10) {
                  System.out.println("It's a critical  hit!");
                  Wait(1000);
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( squirtleCurStats[5], 2, watergun[0], squirtleCurStats[3], GetActivePokemonStats(activeOppPokemon)[3], 1.5f, 2f, 2f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining.");
                  Wait(1000);

                } else {
                  System.out.println("It's a hit!");
                  Wait(1000);
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( squirtleCurStats[5], 1, watergun[0], squirtleCurStats[3], GetActivePokemonStats(activeOppPokemon)[3], 1.5f, 2f, 2f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  System.out.println("It's super effective!");
                  Wait(1000);
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining.");
                  Wait(1000);
                }
              } else {
                System.out.println("But it failed");
                Wait(1000);
              }
              unchosen = false;
            }
            if (move.equals("5")) {
              Fight();
            }
          }
        }

        
        if (activePokemon.equals("Bulbasaur")) {
          while (unchosen) {
            System.out.println("1. Tackle  " + tackle[2] + " pp");
            Wait(500);
            System.out.println("2. Growl " + growl[2] + " pp");
            Wait(500);
            System.out.println("3. Leech Seed " + leechSeed[2] + " pp");
            Wait(500);
            System.out.println("4. Vine Whip " + vineWhip[2] + " pp");
            Wait(500);
            System.out.println("5. Back");
            Wait(1000);
            String move = obj.nextLine();
            if (move.equals("1")) {
              System.out.println("Bulbasaur used Tackle!");
              Wait(1000);
              Random rand = new Random();
              int min = 0, max = 100;
              int random = rand.nextInt(max - min + 1) + min;
              if (random <= tackle[1]) {
                if (random < 10) {
                  System.out.println("It's a critical  hit!");
                  Wait(1000);
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( bulbasaurCurStats[5], 2, tackle[0], bulbasaurCurStats[3], GetActivePokemonStats(activeOppPokemon)[3], 1f, 0.5f, 1f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining.");
                  Wait(1000);

                } else {
                  System.out.println("It's a hit!");
                  Wait(1000);
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( bulbasaurCurStats[5], 1, tackle[0], bulbasaurCurStats[3], GetActivePokemonStats(activeOppPokemon)[3], 1f, 0.5f, 1f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining.");
                  Wait(1000);
                }
              } else {
                System.out.println("But it failed");
                Wait(1000);
              }
              unchosen = false;
            }
            if (move.equals("2")) {
              System.out.println("Bulbasaur used Growl!");
              Wait(1000);
              GetActivePokemonStats(activeOppPokemon)[1] -= 2;
              System.out.print(activeOppPokemon + "'s attack fell!");
              unchosen = false;

            }
            if (move.equals("3")) {
              System.out.println("Bulbasaur used Leech Seed!");
              Wait(1000);
              Random rand = new Random();
              int min = 0, max = 100;
              int random = rand.nextInt(max - min + 1) + min;
              if (random <= leechSeed[1] && !geodudeStatus.contains("Seeding")) {
                  System.out.println("It's a hit!");
                  GetActivePokemonStatus(activeOppPokemon).add("Seeding");
                  Wait(1000);
              } else {
                System.out.println("But it failed");
                Wait(1000);
              }
              unchosen = false;
            }
            if (move.equals("4")) {
              System.out.println("Bulbasaur used Vine Whip!");
              Wait(1000);
              Random rand = new Random();
              int min = 0, max = 100;
              int random = rand.nextInt(max - min + 1) + min;
              if (random <= vineWhip[1]) {
                if (random < 10) {
                  System.out.println("It's a critical  hit!");
                  Wait(1000);
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( bulbasaurCurStats[5], 1, vineWhip[0], bulbasaurCurStats[3], GetActivePokemonStats(activeOppPokemon)[3], 1.5f, 2f, 2f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining.");
                  Wait(1000);

                } else {
                  System.out.println("It's a hit!");
                  Wait(1000);
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( bulbasaurCurStats[5], 1, vineWhip[0], bulbasaurCurStats[3], GetActivePokemonStats(activeOppPokemon)[3], 1.5f, 2f, 2f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println("It's Super Effective!");
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining.");
                  Wait(1000);
                }
              } else {
                System.out.println("But it failed");
                Wait(1000);
              }
              unchosen = false;
            }
            if (move.equals("5")) {
              Fight();
            }
          }
        }

        
        if (activePokemon.equals("Charmander")) {
          while (unchosen) {
            System.out.println("1. Scratch  " + scratch[2] + " pp");
            Wait(500);
            System.out.println("2. Growl  " + growl[2] + " pp");
            Wait(500);
            System.out.println("3. Ember " + ember[2] + " pp");
            Wait(500);
            System.out.println("4. Leer " + leer[2] + " pp");
            Wait(500);
            System.out.println("5. Back");
            Wait(500);
            String move = obj.nextLine();
            if (move.equals("1")) {
              System.out.println("Charmander used Scratch!");
              Wait(1000);
              Random rand = new Random();
              int min = 0, max = 100;
              int random = rand.nextInt(max - min + 1) + min;
              if (random <= scratch[1]) {
                if (random < 10) {
                  System.out.println("It's a critical  hit!");
                  Wait(1000);
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( charmanderCurStats[5], 2, scratch[0], charmanderCurStats[3], GetActivePokemonStats(activeOppPokemon)[3], 1f, 0.5f, 1f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining.");
                  Wait(1000);

                } else {
                  System.out.println("It's a hit!");
                  Wait(1000);
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( charmanderCurStats[5], 1, scratch[0], charmanderCurStats[3], GetActivePokemonStats(activeOppPokemon)[3], 1f, 0.5f, 1f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println("It's not very effective!");
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining.");
                  Wait(1000);
                }
              } else {
                System.out.println("But it failed");
                Wait(1000);
              }
              unchosen = false;
            }
            if (move.equals("2")) {
              System.out.println("Charmander used Growl!");
              GetActivePokemonStats(activeOppPokemon)[1] -= 2;
              System.out.print(activeOppPokemon + "'s attack fell!");
              unchosen = false;

            }
            if (move.equals("3")) {
              System.out.println("Charmander used Ember!");
              Random rand = new Random();
              int min = 0, max = 100;
              int random = rand.nextInt(max - min + 1) + min;
              if (random <= ember[1]) {
                if (random < 100) {
                  System.out.println("It's a hit!");
                  Wait(1000);
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( charmanderCurStats[5], 2, tackle[0], charmanderCurStats[3], GetActivePokemonStats(activeOppPokemon)[3], 1f, 0.5f, 1f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println("It's not very effective!");
                  Wait(1000);
                  System.out.println(activeOppPokemon + " was burned!");
                  Wait(1000);
                  GetActivePokemonStatus(activeOppPokemon).add("Burn");
                  burnTimer = 3;
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining!");
                  Wait(1000);


                } else {
                  System.out.println("It's a hit!");
                  Wait(1000);
                  GetActivePokemonStats(activeOppPokemon)[0] -= Damage( charmanderCurStats[5], 2, tackle[0], charmanderCurStats[3], GetActivePokemonStats(activeOppPokemon)[3], 1f, 0.5f, 1f, GetActivePokemonStats(activeOppPokemon)[0], "Geodude");
                  if(GetActivePokemonStats(activeOppPokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activeOppPokemon)[0] = 0;
                  }
                  System.out.println("It's not very effective!");
                  Wait(1000);
                  System.out.println(activeOppPokemon + " has " + GetActivePokemonStats(activeOppPokemon)[0] + " health remaining!");
                  Wait(1000);

                }
              } else {
                System.out.println("But it failed");
              }
              unchosen = false;
            }
            if (move.equals("4")) {
              System.out.println("Charmander used Leer!");
              GetActivePokemonStats(activeOppPokemon)[2] -= 2;
              System.out.print(activeOppPokemon + "'s defense fell!");
              unchosen = false;
            }
            if (move.equals("5")) {
              Fight();
            }
          }
        }
      }
      if (choice.equals("2")) {
        while (unchosen) {
          System.out.println("What item will you use?");
          Wait(1000);
          System.out.println("1. Ultraball * 5");
          Wait(500);
          System.out.println("2. Back");
          Wait(1000);
          String item = obj.nextLine();
          if (item.equals("1")) {
            System.out.println("You caught Brock the Rock Type gym leader!");
            Wait(1000);
          }
          if (item.equals("2")) {
            Fight();

          }
        }

      }
      if (choice.equals("3")) {
        Switch();
      }
      if (choice.equals("4")) {
        System.out.println("You can't run away from this fight");
        Wait(1000);
        Fight();
      }
    }

  }
  public static void OppFight()
  {
    if(activeOppPokemon.equals("Geodude"))
    {
      Random moveRand = new Random();
      int choiceMin = 1, choiceMax = 2;
      int move = moveRand.nextInt(choiceMax - choiceMin + 1) + choiceMin;
      if(move == 1)
      {
          System.out.println("Geodude used tackle!");
          Random rand = new Random();
          int min = 0, max = 100;
          int random = rand.nextInt(max - min + 1) + min;
          if (random <= tackle[1]) {
            if (random < 10) {
                Damage( geodudeCurStats[5], 2, tackle[0], geodudeCurStats[1], squirtleCurStats[2], 1f, 1f, 1f, squirtleCurStats[0], "Squirtle");
                System.out.println("It's a critical  hit!");
                Wait(1000);
                System.out.println(activePokemon + " has " + GetActivePokemonStats(activePokemon)[0] + " health remaining!");
                Wait(1000);

            } 
            else {
                GetActivePokemonStats(activePokemon)[0] -= Damage( geodudeCurStats[5], 1, tackle[0], geodudeCurStats[1], squirtleCurStats[2], 1f, 0.5f, 1f, squirtleCurStats[0], "Squirtle");
                System.out.println("It's a hit!");
                Wait(1000);
                System.out.println(activePokemon + " has " + GetActivePokemonStats(activePokemon)[0] + " health remaining!");
                Wait(1000);
            }
          } 
          else {
          System.out.println("But it failed!");
          Wait(1000);
          }
      }
      if(move == 2)
      {
        System.out.println("Geodude used defense curl!");
        Wait(1000);
        System.out.println("Geodude's defense rose!");
        geodudeCurStats[2] += 2;
      }
    }
    else if(activeOppPokemon.equals("Onix"))
    {
      if(bideTimer<=0 || !GetActivePokemonStatus(activeOppPokemon).contains("Bide"))
      {
        Random moveRand = new Random();
        int choiceMin = 1;
        int choiceMax = 3;
        int move = moveRand.nextInt(choiceMax - choiceMin + 1) + choiceMin;
        if(move == 1)
        {
          System.out.println("Onix used Tackle!");
              Wait(1000);
              Random rand = new Random();
              int min = 0, max = 100;
              int random = rand.nextInt(max - min + 1) + min;
              if (random <= tackle[1]) {
                if (random < 10) {
                  GetActivePokemonStats(activePokemon)[0] -= Damage( onixCurStats[5], 2, tackle[0], onixCurStats[1], GetActivePokemonStats(activePokemon)[2], 1f, 1f, 1f, GetActivePokemonStats(activePokemon)[0], activePokemon);
                  System.out.println("It's a critical  hit!");
                  Wait(1000);
                  if(GetActivePokemonStats(activePokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activePokemon)[0] = 0;
                  }
                  System.out.println(activePokemon + " has " + GetActivePokemonStats(activePokemon)[0] + " health remaining.");
                  Wait(1000);

                } else {
                  GetActivePokemonStats(activePokemon)[0] -= Damage( onixCurStats[5], 1, tackle[0], onixCurStats[1], GetActivePokemonStats(activePokemon)[2], 1f, 1f, 1f, GetActivePokemonStats(activePokemon)[0], activePokemon);
                  System.out.println("It's a hit!");
                  Wait(1000);
                  if(GetActivePokemonStats(activePokemon)[0] < 0)
                  {
                    GetActivePokemonStats(activePokemon)[0] = 0;
                  }
                  System.out.println(activePokemon + " has " + GetActivePokemonStats(activePokemon)[0] + " health remaining.");
                  Wait(1000);
        }
        if(move==2)
        {
          System.out.println("Onix used Screech!");
          Wait(1000);
          GetActivePokemonStats(activePokemon)[2]-= 4;
          System.out.println(activePokemon + "'s defense fell sharply!");
          Wait(1000);
        }
        if(move==2)
        {
          System.out.println("Onix used Bide!");
          Wait(1000);
          bideTimer = 3;
          bideStartHealth = GetActivePokemonStats(activeOppPokemon)[0];
          GetActivePokemonStatus(activeOppPokemon).add("Bide");
        }
      }
    }

        
    }
    
  }
  }
  public static int Damage(int lvl, int crit, int pwr, int atk, int def, float STAB, float type1, float type2, int health, String target)
  {
    Random rand = new Random();
    int min = 217, max = 255;
    int random = rand.nextInt(max - min + 1) + min;
    float dmgCalc = (((((2 * lvl * crit / 5) + 2) * pwr * atk / def / 50) + 2) * STAB * type1 * type2 * random/255 ); 
    int dmgDealt = Math.round(dmgCalc); 
    return dmgDealt;
  }
  public static void Status(String afflictedPokemon, String afflictingPokemon) {
      if(GetActivePokemonStatus(afflictedPokemon).contains("Seeding"))
      {
        GetActivePokemonStats(afflictedPokemon)[0] -= Math.round( GetActivePokemonMaxStats(afflictedPokemon)[0]/16 );
        if(GetActivePokemonStats(afflictedPokemon)[0] < 0)
        {
          GetActivePokemonStats(afflictedPokemon)[0] = 0;
        }
        GetActivePokemonStats(afflictingPokemon)[0] += Math.round( GetActivePokemonMaxStats(afflictedPokemon)[0]/16 );
        if(GetActivePokemonStats(afflictingPokemon)[0] > GetActivePokemonMaxStats(afflictingPokemon)[0])
        {
          GetActivePokemonStats(afflictingPokemon)[0] = GetActivePokemonMaxStats(afflictingPokemon)[0];
        }
        
        System.out.println(afflictedPokemon + " took " + Math.round( GetActivePokemonMaxStats(afflictedPokemon)[0]/16 ) + " damage from seedling!" );
        Wait(1000);
        System.out.println(afflictedPokemon + " has " + GetActivePokemonStats(afflictedPokemon)[0] + " health!");
        Wait(1000);
        System.out.println(afflictingPokemon + " healed " + Math.round( GetActivePokemonMaxStats(afflictedPokemon)[0]/16 ) + " damage from seedling!" );
        Wait(1000);
        System.out.println(afflictingPokemon + " has " + GetActivePokemonStats(afflictingPokemon)[0] + " health!");
        Wait(1000);

      }
      if(GetActivePokemonStatus(afflictedPokemon).contains("Burn"))
      {
        GetActivePokemonStats(afflictedPokemon)[0] -= Math.round( GetActivePokemonMaxStats(afflictedPokemon)[0]/16 );
        if(GetActivePokemonStats(afflictedPokemon)[0] < 0)
        {
          GetActivePokemonStats(afflictedPokemon)[0] = 0;
        }
        
        System.out.println(afflictedPokemon + " took " + Math.round( GetActivePokemonMaxStats(afflictedPokemon)[0]/16 ) + " damage from burn!" );
        Wait(1000);
        System.out.println(afflictedPokemon + " has " + GetActivePokemonStats(afflictedPokemon)[0] + " health!");
        Wait(1000);
        burnTimer --;
        if(burnTimer == 0)
        {
          GetActivePokemonStatus(afflictedPokemon).remove("Burn");
          GetActivePokemonStats(afflictedPokemon)[1] += 2;
        }

      }
      if(GetActivePokemonStatus(afflictedPokemon).contains("Bide"))
      {
        bideTimer -= 1;
        if(bideTimer <= 0)
        {
          GetActivePokemonStats(afflictingPokemon)[0] -= (bideStartHealth - bideEndHealth);
          if(GetActivePokemonStats(afflictingPokemon)[0] < 0)
          {
            GetActivePokemonStats(afflictingPokemon)[0] = 0;
          }
          
          System.out.println(afflictingPokemon + " took " + (bideStartHealth - bideEndHealth) + " damage from bide!" );
          Wait(1000);
          System.out.println(afflictingPokemon + " has " + GetActivePokemonStats(afflictingPokemon)[0] + " health!");
          Wait(1000);
          GetActivePokemonStatus(afflictedPokemon).remove("Bide");
          
        }
      }
  }
  public static void Wait(int msec)
  {
    try {
    Thread.sleep(msec);
    } catch (InterruptedException e) {
    Thread.currentThread().interrupt();
    }
  }
  public static Integer[] GetActivePokemonStats(String activePokemon)
  {
    if(activePokemon.equals("Squirtle"))
    {
      return squirtleCurStats;
    }
    if(activePokemon.equals("Bulbasaur"))
    {
      return bulbasaurCurStats;
    }
    if(activePokemon.equals("Charmander"))
    {
      return charmanderCurStats;
    }
    if(activePokemon.equals("Geodude"))
    {
      return geodudeCurStats;
    }
    if(activePokemon.equals("Onix"))
    {
      return onixCurStats;
    }
    return null;
  }
  public static List<String> GetActivePokemonStatus(String activePokemon)
  {
    if(activePokemon.equals("Squirtle"))
    {
      return squirtleStatus;
    }
    if(activePokemon.equals("Bulbasaur"))
    {
      return bulbasaurStatus;
    }
    if(activePokemon.equals("Charmander"))
    {
      return charmanderStatus;
    }
    if(activePokemon.equals("Geodude"))
    {
      return geodudeStatus;
    }
    if(activePokemon.equals("Onix"))
    {
      return onixStatus;
    }
    return null;
  }
  public static Integer[] GetActivePokemonMaxStats(String activePokemon)
  {
    if(activePokemon.equals("Squirtle"))
    {
      return squirtleStats;
    }
    if(activePokemon.equals("Bulbasaur"))
    {
      return bulbasaurStats;
    }
    if(activePokemon.equals("Charmander"))
    {
      return charmanderStats;
    }
    if(activePokemon.equals("Geodude"))
    {
      return geodudeStats;
    }
    if(activePokemon.equals("Onix"))
    {
      return onixStats;
    }
    return null;
  }
  public static void Switch()
  {
    for(int i = 0; i < alivePokemon.size(); i++)
    {
      System.out.println((i+1) + ". " + alivePokemon.get(i));
    }
    while(unchosen)
    {
      String choice = obj.nextLine();
      if(choice.equals("1"))
      {
        if(alivePokemon.get(0) != null)
        {
          if(alivePokemon.get(0).equals(activePokemon))
          {
            Fight();
          }
          activePokemon = alivePokemon.get(0);
          System.out.println("Trainer Red Sent Out " + activePokemon + "!");
          unchosen = false;
        }
      }
      if(choice.equals("2"))
      {
        if(alivePokemon.get(1) != null)
        {
          if(alivePokemon.get(1).equals(activePokemon))
          {
            Fight();
          }
          activePokemon = alivePokemon.get(1);
          System.out.println("Trainer Red Sent Out " + activePokemon + "!");
          unchosen = false;
        }
      }
      if(choice.equals("3"))
      {
        if(alivePokemon.get(2) != null)
        {
          if(alivePokemon.get(2).equals(activePokemon))
          {
            Fight();
          }
          activePokemon = alivePokemon.get(2);
          System.out.println("Trainer Red Sent Out " + activePokemon + "!");
          unchosen = false;
        }
      }
    }
  }
  public static void CheckBrock()
  {
    if(geodudeCurStats[0] <= 0)
      {
        if(justFainted)
        {
          System.out.println("Brock's " + activeOppPokemon + " fainted!");
          Wait(1000);
          System.out.println("Brock sent out his Onix!");
          Wait(1000);
          activeOppPokemon = "Onix";
        }
        if(onixCurStats[0] <= 0)
        {
          System.out.println("You defeated Brock and got the rock badge!");
          System.exit(0);
        }
      }
  }

}


// Squirtle stats: Type - Water, HP - 44, Attack - 48, Defense - 65, Special
// Attack - 50, Special Defense - 64, Speed - 43

// Charmander stats: Type - Fire, HP - 39, Attack - 52, Defense - 43, Sp. Atk -
// 60, Sp. Def - 50, Speed - 65

// Bulbsaur stats: Type - Water, HP - 45, Attack - 49, Defense - 49, Sp. Atk -
// 65, Sp. Def - 65, Speed - 45
// @Test
// void addition() {
// assertEquals(2, 1 + 1);
// }