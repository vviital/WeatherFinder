import Ember from 'ember';

export default Ember.Route.extend({
    model() {
      return this.store.findAll('weather')
          .then((res) => {
            console.log('all');
            let cnt = 0;
            const maxRecord = 20;
            let weathers = res.filter((item) => {
              cnt++;
              return cnt <= maxRecord;
            });
            console.log(res);
            return weathers;
            })
          .catch((error) => {
                  console.log(error);
                });
    }
  });
