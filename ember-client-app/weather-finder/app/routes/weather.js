import Ember from 'ember';

export default Ember.Route.extend({
  model() {
    return this.store.findAll("weather")
      .then((result) => {
        result.forEach((value) => {
          console.log(`value = ${value.get('day')}`);
          let weathers = value.get('weatherList');
          weathers.forEach((w) => {
            console.log(w.temperature);
          });
        });
      })
      .catch((error) => {
        console.log(error);
      });
  }
});
