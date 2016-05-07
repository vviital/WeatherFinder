import Ember from 'ember';

export default Ember.Route.extend({
  actions: {
    find(params) {
      this.transitionTo('weather.day', params.date);
    }
  }
});
