import Ember from 'ember';

export default Ember.Component.extend({
    actions: {
        find() {
            const {date} = this.getProperties('date');
            console.log('TODO need to process date!!!');
            this.sendAction('onFind', {date});
        }
    }
});
