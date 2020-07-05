# FarmManagement

GET REQUESTS
http://localhost:8080/get-pondList/1
http://localhost:8080/get-blockList/1
http://localhost:8080/login?mobileNumber=1234567890&password=1234abcd

POST REQUESTS
http://localhost:8080/add-farmer

{
    "farmerName": "Raju",
    "farmName": "farm1",
    "address": {
        "addressLine1" : "line1",
        "addressLine2" : "line1",
        "district":"dist1",
        "state":"state1",
        "pinCode":1234
    },
    "mobileNumber": "1234567890",
    "password": "1234abcd",
    "corporate": false
}

http://localhost:8080/save-pondlist
[
    {
    
    "pondName": "pond 200",
    "pondSize": "20",
    "active" : true,
    "farmerId":1
    },
    {
    "pondName": "pond ",
    "pondSize": "10",
    "active" : false,
    "farmerId":1
    }
]

http://localhost:8080/save-blockList

    {
        
        "blockName": "block2",
        "pondList": [
            {
                
                "pondName": "pond 2200",
                "pondSize": 20.0,
                "active": true,
                "farmerId": 1
            },
			{
                
                "pondName": "pond 32300",
                "pondSize": 20.0,
                "active": false,
                "farmerId": 1
            }
        ],
		"farmerId": 1
    }
