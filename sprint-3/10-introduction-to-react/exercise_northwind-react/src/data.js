const employees = [
    {
        "employeeId": 1,
        "lastName": "Davolio",
        "firstName": "Nancy",
        "title": "Sales Representative",
        "titleOfCourtesy": "Ms.",
        "birthDate": "1978-12-08T00:00:00",
        "hireDate": "2012-05-01T00:00:00",
        "address": "507 - 20th Ave. E.Apt. 2A",
        "city": "Seattle",
        "state": "WA",
        "zipCode": "98122",
        "country": "USA",
        "phone": "(206) 555-9857",
        "extension": "5467",
        "notes": "Education includes a BA in psychology from Colorado State University in 1970.  She also completed \"The Art of the Cold Call.\"  Nancy is a member of Toastmasters International.",
        "salary": 2954.55,
        "managerId": 2
    },
    {
        "employeeId": 2,
        "lastName": "Fuller",
        "firstName": "Andrew",
        "title": "Vice President, Sales",
        "titleOfCourtesy": "Dr.",
        "birthDate": "1982-02-19T00:00:00",
        "hireDate": "2012-08-14T00:00:00",
        "address": "908 W. Capital Way",
        "city": "Tacoma",
        "state": "WA",
        "zipCode": "98401",
        "country": "USA",
        "phone": "(206) 555-9482",
        "extension": "3457",
        "notes": "Andrew received his BTS commercial in 1974 and a Ph.D. in international marketing from the University of Dallas in 1981.  He is fluent in French and Italian and reads German.  He joined the company as a sales representative, was promoted to sales manager in January 1992 and to vice president of sales in March 1993.  Andrew is a member of the Sales Management Roundtable, the Seattle Chamber of Commerce, and the Pacific Rim Importers Association.",
        "salary": 2254.49,
        "managerId": 0
    },
    {
        "employeeId": 3,
        "lastName": "Leverling",
        "firstName": "Janet",
        "title": "Sales Representative",
        "titleOfCourtesy": "Ms.",
        "birthDate": "1993-08-30T00:00:00",
        "hireDate": "2012-04-01T00:00:00",
        "address": "722 Moss Bay Blvd.",
        "city": "Kirkland",
        "state": "WA",
        "zipCode": "98033",
        "country": "USA",
        "phone": "(206) 555-3412",
        "extension": "3355",
        "notes": "Janet has a BS degree in chemistry from Boston College (1984).  She has also completed a certificate program in food retailing management.  Janet was hired as a sales associate in 1991 and promoted to sales representative in February 1992.",
        "salary": 3119.15,
        "managerId": 2
    },
    {
        "employeeId": 4,
        "lastName": "Peacock",
        "firstName": "Margaret",
        "title": "Sales Representative",
        "titleOfCourtesy": "Mrs.",
        "birthDate": "1967-09-19T00:00:00",
        "hireDate": "2013-05-03T00:00:00",
        "address": "4110 Old Redmond Rd.",
        "city": "Redmond",
        "state": "WA",
        "zipCode": "98052",
        "country": "USA",
        "phone": "(206) 555-8122",
        "extension": "5176",
        "notes": "Margaret holds a BA in English literature from Concordia College (1958) and an MA from the American Institute of Culinary Arts (1966).  She was assigned to the London office temporarily from July through November 1992.",
        "salary": 1861.08,
        "managerId": 2
    },
    {
        "employeeId": 5,
        "lastName": "Buchanan",
        "firstName": "Steven",
        "title": "Sales Manager",
        "titleOfCourtesy": "Mr.",
        "birthDate": "1985-03-04T00:00:00",
        "hireDate": "2013-10-17T00:00:00",
        "address": "14 Garrett Hill",
        "city": "London",
        "state": null,
        "zipCode": "SW1 8JR",
        "country": "UK",
        "phone": "(71) 555-4848",
        "extension": "3453",
        "notes": "Steven Buchanan graduated from St. Andrews University, Scotland, with a BSC degree in 1976.  Upon joining the company as a sales representative in 1992, he spent 6 months in an orientation program at the Seattle office and then returned to his permanent post in London.  He was promoted to sales manager in March 1993.  Mr. Buchanan has completed the courses \"Successful Telemarketing\" and \"International Sales Management.\"  He is fluent in French.",
        "salary": 1744.21,
        "managerId": 2
    },
    {
        "employeeId": 6,
        "lastName": "Suyama",
        "firstName": "Michael",
        "title": "Sales Representative",
        "titleOfCourtesy": "Mr.",
        "birthDate": "1993-07-02T00:00:00",
        "hireDate": "2013-10-17T00:00:00",
        "address": "Coventry House Miner Rd.",
        "city": "London",
        "state": null,
        "zipCode": "EC2 7JR",
        "country": "UK",
        "phone": "(71) 555-7773",
        "extension": "428",
        "notes": "Michael is a graduate of Sussex University (MA, economics, 1983) and the University of California at Los Angeles (MBA, marketing, 1986).  He has also taken the courses \"Multi-Cultural Selling\" and \"Time Management for the Sales Professional.\"  He is fluent in Japanese and can read and write French, Portuguese, and Spanish.",
        "salary": 2004.07,
        "managerId": 5
    },
    {
        "employeeId": 7,
        "lastName": "King",
        "firstName": "Robert",
        "title": "Sales Representative",
        "titleOfCourtesy": "Mr.",
        "birthDate": "1990-05-29T00:00:00",
        "hireDate": "2014-01-02T00:00:00",
        "address": "Edgeham Hollow Winchester Way",
        "city": "London",
        "state": null,
        "zipCode": "RG1 9SP",
        "country": "UK",
        "phone": "(71) 555-5598",
        "extension": "465",
        "notes": "Robert King served in the Peace Corps and traveled extensively before completing his degree in English at the University of Michigan in 1992, the year he joined the company.  After completing a course entitled \"Selling in Europe,\" he was transferred to the London office in March 1993.",
        "salary": 1991.55,
        "managerId": 5
    },
    {
        "employeeId": 8,
        "lastName": "Callahan",
        "firstName": "Laura",
        "title": "Inside Sales Coordinator",
        "titleOfCourtesy": "Ms.",
        "birthDate": "1988-01-09T00:00:00",
        "hireDate": "2014-03-05T00:00:00",
        "address": "4726 - 11th Ave. N.E.",
        "city": "Seattle",
        "state": "WA",
        "zipCode": "98105",
        "country": "USA",
        "phone": "(206) 555-1189",
        "extension": "2344",
        "notes": "Laura received a BA in psychology from the University of Washington.  She has also completed a course in business French.  She reads and writes French.",
        "salary": 2100.5,
        "managerId": 2
    },
    {
        "employeeId": 9,
        "lastName": "Dodsworth",
        "firstName": "Anne",
        "title": "Sales Representative",
        "titleOfCourtesy": "Ms.",
        "birthDate": "1996-01-27T00:00:00",
        "hireDate": "2014-11-15T00:00:00",
        "address": "7 Houndstooth Rd.",
        "city": "London",
        "state": null,
        "zipCode": "WG2 7LT",
        "country": "UK",
        "phone": "(71) 555-4444",
        "extension": "452",
        "notes": "Anne has a BA degree in English from St. Lawrence College.  She is fluent in French and German.",
        "salary": 2333.33,
        "managerId": 5
    }
]

export default employees