#include <iostream>
#include <fstream>
#include <vector>
#include <filesystem>
#include <string>
#include <algorithm>
#include <sstream>
#include <iterator>

using namespace std;
using area_t = std::vector<std::string>;

std::vector<std::pair<int, int>> adjacentTypes = {
    { 0,  1},
    { 1,  1},
    { 1,  0},
    { 1, -1},
    { 0, -1},
    {-1, -1},
    {-1,  0},
    {-1,  1}
};

std::vector<std::string> readLines() {
    std::ifstream infile("input.txt");
	std::string line;
	std::vector<std::string> lines;
	while (std::getline(infile, line)) {
		lines.push_back(line);
	}
	return lines;
}

std::string areaToString(area_t area) {
    std::ostringstream oss;
    const char* separator = ",";

    oss << "[\n";

    if (!area.empty()) {
        for(size_t i = 0; i < area.size(); i++) {
            oss << "\t \"" << area[i] << "\"";
            if(i < area.size() - 1) oss << separator;
            oss << "\n";
        }
    }

    oss << "]";

    return oss.str();
}
bool isOccupied(area_t area, uint64_t x, uint64_t y) {
    return x >= 0 && x < area.size() && y >= 0 && y < area[x].length() && area[x][y] == '#';
}

/*bool isAdjacentOccupied(area_t area, uint16_t x, uint16_t y, std::pair<int, int> adjacentType) {
    return isOccupied(area, x + adjacentType.first, y + adjacentType.second);
}*/

bool isAdjacentOccupied(area_t area, uint64_t  x, uint64_t  y, uint64_t  offsetX, uint64_t  offsetY) {
    return isOccupied(area, x + offsetX, y + offsetY);
}

/*bool hasNoAdjacentsOccupied(area_t area, uint16_t x, uint16_t y) {
    uint16_t amount = 0;
    for(std::pair<int, int> adjacentType : adjacentTypes) {
        if(isAdjacentOccupied(area, x, y, adjacentType)) return false;
    }
    return true;
}

bool hasAdjacentsOccupied(area_t area, uint16_t x, uint16_t y, uint16_t amountAdjacentsOccupied) {
    uint16_t amount = 0;
    for(std::pair<int, int> adjacentType : adjacentTypes) {
        /*cout << (x >= 0 && x < area.size() && y > 0 && y < area[x].length());
        if((x + adjacentType.first) >= 0 && (x + adjacentType.first) < area.size() && (y + adjacentType.second) >= 0 && (y + adjacentType.second) < area[x].length()) {
            cout << x << "," << y << ", " << "(" << adjacentType.first << "," << adjacentType.second << ")" << ": " << area[x + adjacentType.first][y + adjacentType.second] << "\n";
        } else {
            cout << x << "," << y << ", " << "(" << adjacentType.first << "," << adjacentType.second << ")" << ": " << "a\n";
        }*//*
        amount += isAdjacentOccupied(area, x, y, adjacentType);
    }
    return amount >= amountAdjacentsOccupied;
}*/

uint64_t  countAdjacentsOccupied(area_t area, uint64_t x, uint64_t y) {
    uint64_t  amount = 0;
    amount += isAdjacentOccupied(area, x, y,  0,  1);
    amount += isAdjacentOccupied(area, x, y,  1,  1);
    amount += isAdjacentOccupied(area, x, y,  1,  0);
    amount += isAdjacentOccupied(area, x, y,  1, -1);
    amount += isAdjacentOccupied(area, x, y,  0, -1);
    amount += isAdjacentOccupied(area, x, y, -1, -1);
    amount += isAdjacentOccupied(area, x, y, -1,  0);
    amount += isAdjacentOccupied(area, x, y, -1,  1);
    return amount;
}


int main() {
	area_t area = readLines();
	area_t newArea = area;

    do {
        area = newArea;
        for(int i = 0; i < newArea.size(); i++) {
            for(int j = 0; j < newArea.front().length(); j++) {
                if(area[i][j] == 'L' && countAdjacentsOccupied(area, i, j) == 0) {
                    /*if(hasNoAdjacentsOccupied(area, i, j))*/ newArea[i][j] = '#';
                } else if(area[i][j] == '#' && countAdjacentsOccupied(area, i, j) >= 4) {
                    /*if(hasAdjacentsOccupied(area, i, j, 4))*/ newArea[i][j] = 'L';
                }
            }
        }
        //cout << areaToString(newArea) << "\n";
    } while(area != newArea);

    uint64_t occupiedAmount = 0;

    for(int i = 0; i < newArea.size(); i++) for(int j = 0; j < newArea[i].length(); j++) if(isOccupied(newArea, i, j)) occupiedAmount++;

    cout << occupiedAmount;

    return 0;
}