# design-pattern
  ## Singletone desgin pattern
    here we make somehow perfect singletone design pattern but except one case that is reflection api we fail there 
    thats not our issue thats java programming reflection api who kill the private concept. 
    here we make Singletone class that having private constructor and who can not more than one instantiate some how people         getting private constructor. we manage using class level boolean type.and we make static factory method who gives our class     instance  and this methos is making thread-safe using synchronised block and two time checking.here one more is main imp       concept we override clone method here to prevent clonning and readResolve() to prevent after deserialization creating          second  object.
    
