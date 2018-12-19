package design;

abstract class CPU{}
class EmberCPU extends CPU{}
class EnginoloCPU extends CPU{}


abstract class MMU{}
class EmberMMU extends MMU{ }
class EnginoloMMU extends MMU{}


enum  Architerecture {
    ENGINOLA, EMB

}
public class BasicAbstractFactory {
}
