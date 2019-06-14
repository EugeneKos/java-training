package ru.eugene.java.learn.behaviour.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Паттерн Наблюдатель, используется в сценарии издатель подписчик.
 *
 * Когда после изменения состояния одного объекта требуется что-то сделать в других,
 * но вы не знаете наперёд, какие именно объекты должны отреагировать.
 *
 * Паттерн Наблюдатель позволяет любому объекту с интерфейсом подписчика зарегистрироваться
 * на получение оповещений о событиях, происходящих в объектах-издателях.
 */
public class EventManager {
    private Map<EventType, List<EventListener>> subscribes = new HashMap<>();

    public EventManager() {
        for (EventType type : EventType.values()){
            subscribes.put(type, new ArrayList<>());
        }
    }

    public void addSubscribe(EventType type, EventListener listener){
        subscribes.get(type).add(listener);
    }

    public void removeSubscribe(EventListener listener){
        for (Map.Entry<EventType, List<EventListener>> entry : subscribes.entrySet()){
            entry.getValue().remove(listener);
        }
    }

    public void notifyAllSubscribes(EventType type){
        List<EventListener> listeners = subscribes.get(type);
        if(listeners != null){
            for (EventListener listener : listeners){
                listener.onEvent();
            }
        }
    }
}
