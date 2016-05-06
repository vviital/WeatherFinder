export default function() {
  this.get('http://localhost:8080/weathers', function(db, request) {
    let weathers = [
    {
      "id": 1,
      "weatherList": [
        {
          "id": 1,
          "temperature": "+5 +7",
          "pressure": "744…746",
          "windSpeed": "3…6",
          "windDirection": "юго-восточный",
          "cloudiness": " пасмурно ",
          "humidity": "87…92",
          "dayTime": "ночь"
        },
        {
          "id": 2,
          "temperature": "+5 +7",
          "pressure": "744…746",
          "windSpeed": "3…6",
          "windDirection": "южный",
          "cloudiness": " пасмурно, дождь ",
          "humidity": "88…93",
          "dayTime": "утро"
        },
        {
          "id": 3,
          "temperature": "+6 +8",
          "pressure": "745…747",
          "windSpeed": "3…6",
          "windDirection": "юго-восточный",
          "cloudiness": " облачно ",
          "humidity": "83…88",
          "dayTime": "день"
        },
        {
          "id": 4,
          "temperature": "+4 +6",
          "pressure": "743…745",
          "windSpeed": "3…6",
          "windDirection": "юго-восточный",
          "cloudiness": " облачно ",
          "humidity": "87…92",
          "dayTime": "вечер"
        }
      ],
      "day": "2008-12-01",
      city: {
        cityName: 'Гродно',
        cityUrl: 'grodno'
      }
    },
    {
      "id": 2,
      "weatherList": [
        {
          "id": 5,
          "temperature": "+5 +7",
          "pressure": "744…746",
          "windSpeed": "3…6",
          "windDirection": "юго-восточный",
          "cloudiness": " пасмурно ",
          "humidity": "87…92",
          "dayTime": "ночь"
        },
        {
          "id": 6,
          "temperature": "+5 +7",
          "pressure": "744…746",
          "windSpeed": "3…6",
          "windDirection": "южный",
          "cloudiness": " пасмурно, дождь ",
          "humidity": "88…93",
          "dayTime": "утро"
        },
        {
          "id": 7,
          "temperature": "+6 +8",
          "pressure": "745…747",
          "windSpeed": "3…6",
          "windDirection": "юго-восточный",
          "cloudiness": " облачно ",
          "humidity": "83…88",
          "dayTime": "день"
        },
        {
          "id": 8,
          "temperature": "+4 +6",
          "pressure": "743…745",
          "windSpeed": "3…6",
          "windDirection": "юго-восточный",
          "cloudiness": " облачно ",
          "humidity": "87…92",
          "dayTime": "вечер"
        }
      ],
      day: '2012-12-01',
      city: {
        cityName: 'Гродно',
        cityUrl: 'grodno'
      }
    },
    {
      "id": 3,
      "weatherList": [
        {
          "id": 12826,
          "temperature": "+5 +7",
          "pressure": "744…746",
          "windSpeed": "3…6",
          "windDirection": "юго-восточный",
          "cloudiness": " пасмурно ",
          "humidity": "87…92",
          "dayTime": "ночь"
        },
        {
          "id": 12827,
          "temperature": "+5 +7",
          "pressure": "744…746",
          "windSpeed": "3…6",
          "windDirection": "южный",
          "cloudiness": " пасмурно, дождь ",
          "humidity": "88…93",
          "dayTime": "утро"
        },
        {
          "id": 12828,
          "temperature": "+6 +8",
          "pressure": "745…747",
          "windSpeed": "3…6",
          "windDirection": "юго-восточный",
          "cloudiness": " облачно ",
          "humidity": "83…88",
          "dayTime": "день"
        },
        {
          "id": 12829,
          "temperature": "+4 +6",
          "pressure": "743…745",
          "windSpeed": "3…6",
          "windDirection": "юго-восточный",
          "cloudiness": " облачно ",
          "humidity": "87…92",
          "dayTime": "вечер"
        }
      ],
      day: '2011-12-01',
      city: {
        cityName: 'Минск',
        cityUrl: 'minsk'
      }
    },
      {
      "id": 4,
      "weatherList": [
        {
          "id": 9,
          "temperature": "+5 +7",
          "pressure": "744…746",
          "windSpeed": "3…6",
          "windDirection": "юго-восточный",
          "cloudiness": " пасмурно ",
          "humidity": "87…92",
          "dayTime": "ночь"
        },
        {
          "id": 10,
          "temperature": "+5 +7",
          "pressure": "744…746",
          "windSpeed": "3…6",
          "windDirection": "южный",
          "cloudiness": " пасмурно, дождь ",
          "humidity": "88…93",
          "dayTime": "утро"
        },
        {
          "id": 11,
          "temperature": "+6 +8",
          "pressure": "745…747",
          "windSpeed": "3…6",
          "windDirection": "юго-восточный",
          "cloudiness": " облачно ",
          "humidity": "83…88",
          "dayTime": "день"
        },
        {
          "id": 12,
          "temperature": "+4 +6",
          "pressure": "743…745",
          "windSpeed": "3…6",
          "windDirection": "юго-восточный",
          "cloudiness": " облачно ",
          "humidity": "87…92",
          "dayTime": "вечер"
        }
      ],
      day: '2011-12-03',
      city: {
        cityName: 'Минск',
        cityUrl: 'minsk'
      }
    }
    ];
    if (request.queryParams['filter[day]'] !== undefined) {
      let qDay = new Date(request.queryParams['filter[day]']);
      let result = weathers.filter(function(item) {
        let y1 = new Date(item.day).getYear();
        let m1 = new Date(item.day).getMonth();
        let d1 = new Date(item.day).getDate();
        let y2 = qDay.getYear();
        let m2 = qDay.getMonth();
        let d2 = qDay.getDate();
          console.log(`${y1} ${m1} ${d1} vs ${y2} ${m2} ${d2}`);
        return y1 === y2 && m1 === m2 && d1 === d2;
      });
        console.log(result[0]);
      return {weather: result[0]};
    } else {
      return {weathers : weathers};
    }
  });

  // These comments are here to help you get started. Feel free to delete them.

  /*
    Config (with defaults).

    Note: these only affect routes defined *after* them!
  */
  // this.urlPrefix = '';    // make this `http://localhost:8080`, for example, if your API is on a different server
  // this.namespace = '';    // make this `api`, for example, if your API is namespaced
  // this.timing = 400;      // delay for each request, automatically set to 0 during testing

  /*
    Route shorthand cheatsheet
  */
  /*
    GET shorthands

    // Collections
    this.get('/contacts');
    this.get('/contacts', 'users');
    this.get('/contacts', ['contacts', 'addresses']);

    // Single objects
    this.get('/contacts/:id');
    this.get('/contacts/:id', 'user');
    this.get('/contacts/:id', ['contact', 'addresses']);
  */

  /*
    POST shorthands

    this.post('/contacts');
    this.post('/contacts', 'user'); // specify the type of resource to be created
  */

  /*
    PUT shorthands

    this.put('/contacts/:id');
    this.put('/contacts/:id', 'user'); // specify the type of resource to be updated
  */

  /*
    DELETE shorthands

    this.del('/contacts/:id');
    this.del('/contacts/:id', 'user'); // specify the type of resource to be deleted

    // Single object + related resources. Make sure parent resource is first.
    this.del('/contacts/:id', ['contact', 'addresses']);
  */

  /*
    Function fallback. Manipulate data in the db via

      - db.{collection}
      - db.{collection}.find(id)
      - db.{collection}.where(query)
      - db.{collection}.update(target, attrs)
      - db.{collection}.remove(target)

    // Example: return a single object with related models
    this.get('/contacts/:id', function(db, request) {
      var contactId = +request.params.id;

      return {
        contact: db.contacts.find(contactId),
        addresses: db.addresses.where({contact_id: contactId})
      };
    });

  */
}

/*
You can optionally export a config that is only loaded during tests
export function testConfig() {

}
*/
