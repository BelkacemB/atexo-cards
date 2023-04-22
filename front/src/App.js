import './App.css';
import { useEffect, useState } from 'react';
import { shuffleCards, getSuitOrder, getValuesOrder, getSortedHand } from './api/api';
import Card from './components/Card';
function App() {

  const [currentHand, setCurrentHand] = useState([]);
  const [suitOrder, setSuitOrder] = useState([]);
  const [valuesOrder, setValuesOrder] = useState([]);
  const [sortedHand, setSortedHand] = useState([]);

  useEffect(() => {
    shuffleCards().then((response) => {
      setCurrentHand(response.data);
    });
  }, []);

  useEffect(() => {
    getSuitOrder().then((response) => {
      setSuitOrder(response.data);
    });
  }, [currentHand]);

  useEffect(() => {
    getValuesOrder().then((response) => {
      setValuesOrder(response.data);
    });
  }, [currentHand]);

  useEffect(() => {
    getSortedHand().then((response) => {
      setSortedHand(response.data);
    });
  }, [currentHand, suitOrder, valuesOrder]);

  const generateKey = (card) => {
    return card.suit + card.value;
  }

  return (
    <div className="App">
      <div id="card-row" style={{ display: 'flex', flexDirection: 'row', justifyContent: 'space-around' }}>
        <div id="current-hand">
          <h1>Main</h1>
          {currentHand.map((card) => {
            return <Card key={generateKey(card)} card={card} />
          })}
        </div>
        <div id="suit-order">
          <h1>Ordre couleurs</h1>
          {suitOrder.map((suit) => {
            return <Card key={suit} card={{ suit: suit, value: null }} />
          })}
        </div>
        <div id="values-order">
          <h1>Ordre valeurs</h1>
          {valuesOrder.map((value) => {
            return <Card key={value} card={{ suit: null, value: value }} />
          })}
        </div>
        <div id="sorted-hand">
          <h1>Main triée</h1>
          {sortedHand.map((card) => {
            return <Card key={generateKey(card)} card={card} />
          })}
        </div>
      </div>
      {/* Button to shuffle cards */}

      <button
        style={{
          marginTop: '20px',
          padding: '10px',
          fontSize: '20px',
          borderRadius: '5px',
          cursor: 'pointer'
        }}
      onClick={() => {
        shuffleCards().then((response) => {
          setCurrentHand(response.data);
        });
      }}>Nouvelle main</button>
    </div>
  );
}

export default App;
