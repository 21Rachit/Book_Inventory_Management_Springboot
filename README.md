# Book_Inventory_Management_Springboot

Assumption
One assumption that I made is store in the problem statement refers to the store location. 
For example if the question is list all stores for the user?? 
I have assumed it means that list all the locations where that book store is present under that user. 
For example if a user is in charge of Uttar Pradesh district , then stores under him can be present in Lucknow, Agra, Varanasi etc.


POSTMAN REQUESTS

List of all stores for the user

@RequestMapping(value = "/{user}", method = RequestMethod.GET) (request mapping)

http://localhost:9095/Rachit 


Response Body
[
    "Lucknow",
    "Agra",
    "Chennai"
]


List out all the books in inventory inside the store.

@RequestMapping(value = "/{user}/{store}", method = RequestMethod.GET)

http://localhost:9095/Rachit/Lucknow  
Response Body
[
    [
        "555",
        "Mno",
        29
    ],
    [
        "222",
        "Def",
        5
    ],
    [
        "555",
        "Mno",
        15
    ]
]


Make changes to inventory:

@RequestMapping(value = "/details/{id}", method = RequestMethod.PUT)

http://localhost:9095/details/1

Request Body
{
    "user_name": "Rachit",
    "book_id": "555",
    "book_name": "Mno",
    "book_count": 29,
    "store_name":"Lucknow"

}

Response Body
{
    "id": 1,
    "user_name": "Rachit",
    "book_id": "555",
    "book_name": "Mno",
    "book_count": 29,
    "store_name": "Lucknow"
}

Add a new book.

@RequestMapping(value = "/details/", method = RequestMethod.POST)

http://localhost:9095/details/

Request Body
{
    "user_name": "Rachit",
    "book_id": "555",
    "book_name": "Mno",
    "book_count": 15,
    "store_name":"Lucknow"

}

Response Body
{
    "id": 10,
    "user_name": "Rachit",
    "book_id": "555",
    "book_name": "Mno",
    "book_count": 15,
    "store_name": "Lucknow"
}


Update inventory for an existing book.
@RequestMapping(value = "/update", method = RequestMethod.GET)
http://localhost:9095/update?user_name=Rachit&store=Lucknow&book_name=Mno&count=40

Remove from the inventory.
@RequestMapping(value = "/delete", method = RequestMethod.GET)
http://localhost:9095/delete?user_name=Rachit&store=Lucknow&book_name=Xyz







