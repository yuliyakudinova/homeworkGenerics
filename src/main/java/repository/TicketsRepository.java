package repository;

import domain.Tickets;

public class TicketsRepository {

        private Tickets[] items = new Tickets[0];

        public Tickets findById(int id) {
            for (Tickets item : items) {
                if (item.getId() == id) {
                    return item;
                }
            }
            return null;
        }

        public void save(Tickets item) {
            int lenght = items.length + 1;
            Tickets[] tmp = new Tickets[lenght];
            System.arraycopy(items, 0, tmp, 0, items.length);
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = item;
            items = tmp;
        }

        public Tickets[] findAll() {
            return items;
        }

        public void removeById(int id) {
            int lenght = items.length - 1;
            Tickets[] tmp = new Tickets[lenght];
            int index = 0;
            for (Tickets item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }

    }

