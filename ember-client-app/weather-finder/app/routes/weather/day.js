import Ember from 'ember';

export default Ember.Route.extend({
    model(params) {
        let day = params.day;
        console.log(day);
        return this.store.queryRecord('weather', {filter: {day: day}})
            .then(res => {
                console.log(res.get('day'));
                console.log(res.get('id'));
                console.log(res.get('weatherList'));
                return res;
            })
            .catch((err) => {
                console.log('errrrr');
                console.log(err);
            })
    }
});
