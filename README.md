
To Book Tickets -
POST localhost:8080/event/book
Content-Type: application/json
{
"showId": 2,
"seats": ["B1", "B2"]
}


To fetch all theater details and offers on the particular movie -
GET Mapping - 
http://localhost:8080/event/search?movie=Avengers&city=Bangalore&date=2026-04-10


HLD Architecture- 

<img width="1357" height="544" alt="image" src="https://github.com/user-attachments/assets/e8a7cbc2-0abb-4e94-8c1c-71ddc891b462" />
