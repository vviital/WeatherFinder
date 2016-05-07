import Ember from 'ember';

export default Ember.Route.extend({
    model() {
      return this.store.findAll('weather')
          .then((res) => {
              return res;
            })
          .catch((error) => {
                  console.log(error);
                });
    }
  });
