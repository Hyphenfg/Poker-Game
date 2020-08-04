In order to play Poker: 
    1) The player has to place a valid bet using the number keys of any integer 
    value between 0 and 5  inclusive. As long as the bet is smaller than the 
    amount of money in your bankroll and the bankroll isn't equal to zero 
    they can bet.
        -If the bet is impossible (being less than zero, greater than 5 or greater 
        than the bankroll). The game will prompt the player for a new bet.
    
    2)The deck will be shuffled and dealt to the player. The player's cards will 
    be printed in the terminal.
    
    3)After the player will be prompted to if they want to replace a card (that 
    was printed in the terminal). The player has to respond either true or 
    false for all 5 cards in their hand.
        -The player can replace their entire hand, or not replace any cards,
        but they will be unable to replace a card twice.
        -Any time a new card is chosen the game will print the new hand to the 
        terminal.
    
    4)The hand will then automatically be printed to the terminal and the bankroll
    will be updated.
        The new bankroll will also be printed to the terminal.
    
    5)Then, if the bankroll is greater than zero, the player will then be prompted 
    if they want to play again with two choices: true or false. They have to 
    respond in the terminal. 
        If true go back to step 1.
        If false "Nice Game" will be printed to the terminal and the game will end.

How my poker game works:
    I started writing the poker game by writing the card class. It was relatively 
    straight forward, the only things I added were getters for suit and rank and
    a toString method for the card class.
    
    In my player class along with the given instance variables I also had the 
    instance variable index. Since we weren't allowed to change the addCard 
    method parameters, I was able to using the variable index to get around 
    that to add a card to a specfic place in the ArrayList hand instead of 
    just at the end of the ArrayList. 
    In addition to the given methods, I also included a getCard, getHand, 
    changeIndex, and a toString method.
        The getCard method returns a card at a given index in hand.
        getHand returns the ArrayList hand.
        
    In the Deck class I initialize the card array by having 1 for loop, but
    4 statements that initialize an index in cards. 1 statement for each one of
    the 4 suits. Since the ranks for all cards are the same I was able to 
    utilize the same for loop while just changing how much I was adjusting i by
    and which suit was being inialized in each statement. 
    I import 3 things: Arrays, Collections, and List. 
    This allows me in the shuffle method to use Collections shuffle method
    by converting the cards array to an arrayList and copying the information
    back into the cards array.
        I also have a toString method that I used for testing my code.
    
    The Game class took the most time to code. 
        I added 2 instance variables to the given ones: a scanner so I could 
        take in values from the player and a boolean testHandDone. testHandDone
        is set to true when Game is inialized with parameters and set to false 
        when Game is inialized with no parameters. I use that variable to decide
        in play whether to deal cards to the player. 
    