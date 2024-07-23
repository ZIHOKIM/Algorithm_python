class Solution {
    public int minSumOfLengths(int[] arr, int target) {
           // 누적 합을 저장하는 해시맵
        Map<Integer, Integer> cumSumToIndex = new HashMap<>();
        cumSumToIndex.put(0, 0); // 초기화: 누적 합 0은 인덱스 0에 위치

        int n = arr.length; // 배열의 길이
        int[] minLengths = new int[n + 1]; // 특정 인덱스까지의 최소 부분 배열 길이를 저장하는 배열
        final int infinity = 1 << 30; // 매우 큰 수를 무한대(infinity)로 사용
        minLengths[0] = infinity; // 초기값: 인덱스 0에서 끝나는 부분 배열은 존재하지 않음

        int currentSum = 0; // 현재 부분 배열의 누적 합
        int answer = infinity; // 초기 답변 값을 무한대로 설정

        // 배열을 순회하면서 부분 배열을 찾음
        for (int i = 1; i <= n; ++i) {
            int value = arr[i - 1]; // 현재 배열 값
            currentSum += value; // 현재 부분 배열의 누적 합 업데이트
          
            // 이전까지 찾은 최소 부분 배열 길이를 현재 위치에 복사
            minLengths[i] = minLengths[i - 1];
          
            // (currentSum - target) 값이 해시맵에 존재하는 경우, 부분 배열을 찾은 것임
            if (cumSumToIndex.containsKey(currentSum - target)) {
                int j = cumSumToIndex.get(currentSum - target); // 이전 누적 합이 currentSum - target이었던 인덱스
                minLengths[i] = Math.min(minLengths[i], i - j); // 현재 위치까지의 최소 부분 배열 길이 업데이트
                answer = Math.min(answer, minLengths[j] + i - j); // 두 부분 배열의 길이 합의 최소값 업데이트
            }
          
            // 현재 누적 합과 해당 인덱스를 해시맵에 저장
            cumSumToIndex.put(currentSum, i);
        }
      
        // 답변이 여전히 무한대라면, 두 부분 배열을 찾을 수 없는 경우이므로 -1 반환
        return answer > n ? -1 : answer;
    }
}