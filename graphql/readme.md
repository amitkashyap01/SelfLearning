#GraphQL
* A new API standard
* Developed by Facebook and then opensourced
* Enable declarative data fetching
* GraphQL server exposes single endpoint and responds to queries
* GraphQL was developed to cope with the need for more flexibility and efficiency in client-server communication.
* GraphQL is only a specification. This means GraphQL is a document which describes how a server should behave.

* No more over- and under fetching
* Rapid Product Iterations at Client Side
* Insightful Analytics: Fine grained info 

### Benefits
* GraphQL uses strong type system to define capabilities of an API. GraphQL schema definition
* Schema serves as contract between client and server

* Schema Definition Language (SDL)

### Writing data with Mutations
* 3Types
  * Creating new data
  * Updating existing data
  * deleting existing data
  
  
### Realtime updates with Subscriptions

### GraphQL Schema
* A contract between client and server

```java

	// Schema definitions for Person and Post
	type Person{
		id: ID!
		name: String!
		age: Int!
		posts: [Post!]!
	}
	
	type Post{
		title: String!
		author: Person!
	}
```



#### The Query Type
```java
	
	{
		allPersons{
			name
		}
	}
	
	//Query schema for above will look like
	
	type Query{
		allPersons(last: Int): [Person!]!
	}
	
````

### The mutation type

```java
	mutation{
		createPerson(name: "Bob", age: 36){
			id
		}
	}
	
	//The mutation schema for above will look like
	type Mutation{
		createPerson(name: String!, age: Int!):Person!
	}
```
### The subscription type

```java
	subscription{
		newPerson{
			name
			age
		}
	}
	
	//The subscription schema for above:
	
	type Subscription{
		newPerson: Person!
	}
```

### Completed SDL

```java
	
	// Schema definitions for Person and Post
	type Person{
		id: ID!
		name: String!
		age: Int!
		posts: [Post!]!
	}
	
	type Post{
		title: String!
		author: Person!
	}
	
	//Query Type
	type Query{
		allPersons(last: Int): [Person!]!
		allPosts(last: Int): [Post!]!
	}

	//The mutation type
	type Mutation{
		//CRUD operations for Person
		createPerson(name: String!, age: Int!):Person!
		updatePerson(id:ID!, name: String!, age: Int!):Person!
		deletePerson(id:ID!):Person!
		
		//CRUD Operations for Post
		createPost(title: String!, author: Person!):Post!
		updatePost(id: ID!,title: String!, author: Person!):Post!
		deletePost(id:ID!):Post!
	}
	
	//The subscription type
	type Subscription{
		newPerson: Person!
		updatedPerson: Person!
		deletedPerson: Person!
		
		newPost: Post!
		updatedPost: Post!
		deletedPOst: Post!
	}	
```


### GraphQL Resolver
* GraphQL server creates a resolver function for each field in Query type request.
* **GraphQL Server** is a software component that parses, validates and executes GraphQL queries/mutations.

