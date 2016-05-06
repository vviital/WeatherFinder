import Ember from 'ember';

export default Ember.Route.extend({
  model() {
    return this.store.findAll("weather");
  },
  actions: {
    find(params) {
      this.transitionTo('weather.day', params.date);
    }
  }
});
