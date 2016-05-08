import Ember from 'ember';

export default Ember.Controller.extend({
    customUtil: Ember.inject.service(),

    filteredList: null,
    actions: {
        filter(params) {
          let util = this.get('customUtil');
          const {year, month, day} = params;
          console.log(`${year} ${month} ${day}`);
          let weathers = this.get('store').peekAll('weather');
          let cnt = 0;
          const maxRecord = 20;
          let result = weathers.filter((item) => {
              let ok = true;
              if (util.checkYear(year)) {
                ok = ok && (year == item.get('day').getFullYear());
              }
              if (util.checkMonth(month)) {
                ok = ok && (month == item.get('day').getMonth() + 1);
              }
              if (util.checkDay(day)) {
                ok = ok && (day == item.get('day').getDate());
              }
              if (ok) {
                cnt++;
                ok = cnt <= maxRecord;
              }
              return ok;
            });
          result.sort((a, b) => {
              return b.get('day') - a.get('day');
            });
          this.set('filteredList', result);
        },
        reset() {
          this.get('store').findAll('weather', {reload: true});
        }
      }
  });
