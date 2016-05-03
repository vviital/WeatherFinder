import DS from 'ember-data';
import Ember from 'ember';

export default DS.RESTAdapter.extend({
  namespace: '',
  host: 'http://localhost:8080'
});
