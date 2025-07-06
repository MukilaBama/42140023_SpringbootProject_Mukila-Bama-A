// static/js/script.js
document.addEventListener('DOMContentLoaded', () => {
    const slotSelect = document.querySelector('select[name="slot"]');
    if (slotSelect) {
        slotSelect.addEventListener('change', function() {
            alert(`You selected ${this.value} slot.`);
        });
    }
});
