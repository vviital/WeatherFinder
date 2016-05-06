import Ember from 'ember';

export default Ember.Controller.extend({
    filteredList: null,
    actions: {
        filter(params) {
            const {year, month, day} = params;
            console.log(`${year} ${month} ${day}`);
            let weathers = this.get('store').peekAll('weather');
            let result = weathers.filter((item) => {
                let ok = true;
                if (year !== undefined)
                    ok = ok && (year == item.get('day').getFullYear());
                if (month !== undefined)
                    ok = ok && (month == item.get('day').getMonth());
                if (day !== undefined) {
                    ok = ok && (day == item.get('day').getDate());
                }
                return ok;
            });
            this.set('filteredList', result);
        }
    }
});
