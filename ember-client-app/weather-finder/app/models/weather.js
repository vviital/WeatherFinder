import DS from 'ember-data';

export default DS.Model.extend({
  day: DS.attr("date"),
  weatherList: DS.attr()
});
