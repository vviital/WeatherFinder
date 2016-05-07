import Ember from 'ember';

export default Ember.Component.extend({
    customUtil: Ember.inject.service(),
    errors: false,

    actions: {
        find() {
          const {date} = this.getProperties('date');
          let util = this.get('customUtil');
          let arr = util.parseDate(date);
          if (util.checkDate(arr)) {
            this.sendAction('onFind', {date});
          } else {
            this.set('errors', {message: 'wrong date format!!!'});
          }
        }
      }
  });
