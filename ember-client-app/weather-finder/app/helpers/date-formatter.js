import Ember from 'ember';

export function dateFormatter(params/*, hash*/) {
  let date = params.get('firstObject');
  let formattedDate = `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`;
  return formattedDate;
}

export default Ember.Helper.helper(dateFormatter);
