
public class JumpFloor {
	public int JumpFloor(int target) {
		if (target == 0) {
			return 0;
		} else if (target == 1) {
			return 1;
		} else if (target == 2) {
			return 2;
		} else {
			return JumpFloor(target - 2) + JumpFloor(target - 1);
		}
    }
	
	public int JumpFloorII(int target) {
        if (target == 0) {
        	return 0;
        } else if (target == 1) {
        	return 1;
        } else if (target == 2) {
			return 2;
		} else {
			int result = 1;
			for (int i = 1; i < target; i ++) {
				result += JumpFloorII(i);
			}
			return result;
		}
    }
	
	
}
