import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {
  this.route('weather', function() {
    this.route('day', {path: ':day'});
    this.route('all');
  });
});

export default Router;
