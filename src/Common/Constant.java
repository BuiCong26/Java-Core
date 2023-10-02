package Common;

public class Constant {
    public final class ConstantHuman{
        public static final int MAX_NAME = 100;
        public static final int MIN_YEAR = 1900;
        public static final int MAX_ADDRESS = 300;
        public static final float MIN_WEIGHT = 50.0f;
        public static final float MAX_WEIGHT = 300.0f;
        public static final float MIN_HEIGHT = 5.0f;
        public static final float MAX_HEIGHT = 1000.0f;
        public static final String REGEX_BOD = "^([0]{1}[1-9]{1}|[1-9]{1}|[1-2]{1}[0-9]{1}|[3]{1}[0-1]{1})\\/([0]{1}[1-9]{1}|[1-9]{1}|[1]{1}[0-2]{1})\\/[0-9]{4}$";
    }
    public final class ConstantStudent{
        public static final String REGEX_STUDENT_ID = "^\\w{10}$";
        public static final int MAX_SCHOOL = 200;
        public static final float MIN_MEDIUM_SCORE = 0.0f;
        public static final float MAX_MEDIUM_SCORE = 10.0f;
        public static final int MIN_START_YEAR = 1900;
        public static final String REGEX_START_YEAR = "^[0-9]{4}$";

    }
}
