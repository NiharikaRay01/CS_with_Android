This is a repository created for "CSwithAndroid.withGoogle" held by Google at Dayananda Sagar College of Engineering, Banglore (N0V,2016).
Here are few apps (mainly gaming apps), which uses real time application of "Data structures" & "Algorithm". 

1. Anagrams : 

              An anagram is a word formed by rearranging the letters of another word. For example, cinema is an anagram of iceman.

The mechanics of the game are as follows:

    The game provides the user with a word from the dictionary.
    The user tries to create as many words as possible that contain all the letters of the given word plus one additional letter. Note that adding the extra letter at the beginning or the end without reordering the other letters is not valid. For example, if the game picks the word 'ore' as a starter, the user might guess 'rose' or 'zero' but not 'sore'.
    The user can give up and see the words that they did not guess.

In order to ensure that the game is not too difficult, the computer will only propose words that have at least 5 possible valid anagrams.

2. Scarne's dice :
        
                  Scarne’s Dice is a turn-based dice game where players score points by rolling a die and then:

    if they roll a 1, score no points and lose their turn
    if they roll a 2 to 6:
        add the rolled value to their points
        choose to either reroll or keep their score and end their turn

The winner is the first player that reaches (or exceeds) 100 points.

For example, if a player starts their turn and rolls a 6, they can choose to either ‘hold’ and end their turn, in which case they can add the 6 to their score, or to reroll and potentially score more points.
Let’s say they decide to roll again, and they get a 4. They now have the option to end their turn and add 10 points (6 + 4) to their score, or to roll again to get even more points.
They decide to roll again, but get a 1. Getting a 1 makes the player lose all the points from their turn (so their score is the same as before their turn), and finishes their turn, allowing the second player to begin their turn.
This goes on until one of the players reaches 100 points or more.

3. Ghost-1 :

            Ghost is a word game in which players take turns adding individual letters to a growing word fragment, trying not to be the one to complete a valid word. Each fragment must be the beginning of an actual word, and, for our purposes, we will consider 4 to be the minimum word length. The player who completes a word or creates a fragment that is not the prefix of a word loses the round.

So on player 1's turn, they can:

    challenge player 2's word if they think player 2 has formed a valid word of at least 4 letters. If the fragment is a word, then player 1 wins; if the fragment is not a word, then player 2 wins.
    challenge player 2's word if they think that no word can be formed with the current fragment. Then, player 2 must provide a valid word starting with the current fragment or lose.
    add a letter to move the fragment towards a valid word
    attempt to bluff player 2 by adding a letter that doesn't move the fragment towards a valid word

4. Ghost-2 :
      
            Improving the prevo=ious game using, TRIE data structure.

5. Puzzle :

           A jig-saw puzzle like game, which takes a live photo, shuffles it and then the user tries to solve the puzzle, and try to get the pieces back to their original place; If the player is unable to do so then, the app solves it for the user.


More apps on the way. 


