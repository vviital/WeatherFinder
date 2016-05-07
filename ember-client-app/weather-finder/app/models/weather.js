import DS from 'ember-data';

export default DS.Model.extend({
  day: DS.attr('date'),
  city: DS.attr(),
  weatherList: DS.attr()
});
