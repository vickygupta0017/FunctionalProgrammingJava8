# FunctionalProgrammingJava8

In this Example we will try to learn the use and requirement of functinal programming by taking a scenario and will try to 
create the need for that.

Basically this example contains the number of attempts(in terms of code quality,reusablity and readablity) to solve a 
perticular problem.

Problem statement:Write a method which will filter out our collection based on its color.
Attempt one: If we have a collection of Ball objects having property color then we can think the solution some thing like this.

	public List<Ball> filterByColor(List<Ball> inventory, String color){
		List<Ball> filteredInventory = new ArrayList<>();
		for(Ball ball:inventory) {
			if(color.equals(ball.getColor())) {
				filteredInventory.add(ball);
			}
		}
		return filteredInventory;
	}
But what if our Ball object also having a property named 'weight' and further we need to filter our collection based on the 
weight? then we will write a similar type of method again,but is it the duplication of code we are doing some where?
So we will have the second attempt to resolve this issue.

Attempt two: In this solution we are having a flag, if it is true then we will filter our collection based on color else based
on weight.

public List<Ball> filterBalls(List<Ball> inventory, String color,
			int weight, boolean flag){
		List<Ball> filteredInventory = new ArrayList<>();
		for(Ball ball:inventory) {
			if((flag && color.equals(ball.getColor())) || (!flag && ball.getWeight()>weight)) {
				filteredInventory.add(ball);
			}
		}
		return filteredInventory;
}
Now this code becoms lenthy and unreadable as we do not know,for what the flag used for? or what if we need to filter our
collection based on some new property in future then how can we maintain this code?

Attempt three: Think for a moment if we can pass some behavious to this function instead of just passing the properties?
Yes we can do it by passing the interface(which will have the certain implementations).

.......See code for the implementation.....

Now think a one step furter, to pass some behaviour to the function we had to create many classes (which will actually have 
the behavious inside that). can we do that with out making these classes ?

Attempt four: Yes we can do it by annonyms classes in java

.......See code for the implementation.....

But using and maintaining annonyms classes code is a overhead and error prone(generally it is not advisalble to use more 
annonyms classes in your code). Now we comes to a situation where we want to pass the behavious to our funtion with out making
any blue print for that behaviour, is there any way to do that? before java 8, no.

Attempt five: But with the help of lambda expresions and lambda functions we can do that.

....See code...

Attempt six :The solution can be more readable and easy to write with the help of stream api of java 8

.... See code....
