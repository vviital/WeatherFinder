import Ember from 'ember';

export default Ember.Route.extend({
    model(params) {
      let day = params.day;
      return this.store.findRecord('weather', day)
          .then(result => {
              return result;
            })
          .catch(err => {
              console.log(err);
              return {errors: {message: 'Упс, ничего не нашлось((('}};
            });
      // return this.store.queryRecord('weather', {filter: {day: day}})
      //     .then(res => {
      //         console.log(res.get('day'));
      //         console.log(res.get('id'));
      //         console.log(res.get('weatherList'));
      //         return res;
      //     })
      //     .catch((err) => {
      //         console.log('errrrr');
      //         console.log(err);
      //     });
    }
  });
