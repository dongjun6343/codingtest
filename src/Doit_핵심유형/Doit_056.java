package Doit_핵심유형;

/**
 * 최단 경로 구하기.
 * 1753번
 * 시작점과 다른 노드와 관련된 최단 거리를 구하는 문제.
 * ==> 다익스트라 알고리즘의 가장기본적인 형태를 구현할 수 있는지?
 *
 * 다익스트라 알고리즘
 * 1. 거리배열에서 아직 방문하지 않은 노드 중 현재 값이 가장 작은 노드를 선택.
 * 2. 해당 노드와 연결된 노드들의 최단 거릿값을 공식을 이용해 업데이트
 *    공식 : Min(선택 노드의 거리 배열의 값 + 에지의 가중치, 연결 노드의 거리 배열의 값이 업데이트 된 경우 연결 노드를 큐에 삽입)
 * 3. 큐가 빌때까지 1~2 반복
 */
public class Doit_056 {
}
