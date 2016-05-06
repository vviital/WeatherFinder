import { moduleForComponent, test } from 'ember-qunit';
import hbs from 'htmlbars-inline-precompile';

moduleForComponent('day-weather-show-component', 'Integration | Component | day weather show component', {
  integration: true
});

test('it renders', function(assert) {
  // Set any properties with this.set('myProperty', 'value');
  // Handle any actions with this.on('myAction', function(val) { ... });

  this.render(hbs`{{day-weather-show-component}}`);

  assert.equal(this.$().text().trim(), '');

  // Template block usage:
  this.render(hbs`
    {{#day-weather-show-component}}
      template block text
    {{/day-weather-show-component}}
  `);

  assert.equal(this.$().text().trim(), 'template block text');
});
