package equipments;

public enum Color {
    BLACK {
        @Override
        public String toString() {
            return "black";
        }
    }, GREEN {
        @Override
        public String toString() {
            return "green";
        }
    }, WHITE {
        @Override
        public String toString() {
            return "white";
        }
    }, BLUE {
        @Override
        public String toString() {
            return "blue";
        }
    }
}


